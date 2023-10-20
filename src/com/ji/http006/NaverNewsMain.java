package com.ji.http006;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ji.http001.JiHttpClient;

public class NaverNewsMain {

	// Client id : 6pWWvJLlnH7wUuihsKay
	// Client Secret : JOdlXI05N4

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Scanner k = new Scanner(System.in);
			System.out.print("검색할 것을 입력 : ");
			String search = k.nextLine();
			search = URLEncoder.encode(search, "UTF-8");

			String address = "https://openapi.naver.com/v1/search/blog.xml";
			address += "?query=" + search;

			//	HTTP header : 부가적인 정보 전송
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("X-Naver-Client-Id", "6pWWvJLlnH7wUuihsKay");
			headers.put("X-Naver-Client-Secret", "JOdlXI05N4");
			
			InputStream is = JiHttpClient.download(address,headers);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is,"UTF-8");
			
			int type = xpp.getEventType();
			
			String tagName = null;
			String t = null;
			boolean item = false;

			while(type != XmlPullParser.END_DOCUMENT){
				
				if(type == XmlPullParser.START_TAG) {
								
					tagName = xpp.getName();
					if(tagName.equals("item")) {
						item = true;
					}
					
				}else if(type == XmlPullParser.TEXT) {
					
					if(item) {
						
						if(tagName.equals("title")) {	
							
							t = xpp.getText();
							t = t.replace("<b>", "[");
							t = t.replace("</b>", "]");
							System.out.println(t);
							
						}else if(tagName.equals("description")) {

							t = xpp.getText();
							t = t.replace("<b>", "[");
							t = t.replace("</b>", "]");
							System.out.println(t);
							System.out.println("===============");
							
						}
						
					}		
					
				}else if(type == XmlPullParser.END_TAG) {
					
					tagName = "";
					
				}
				
				xpp.next();
				type = xpp.getEventType();
				
			}
			

		} catch (Exception e) {

			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
