package com.ji.json001;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ji.http001.JiHttpClient;
public class Main {

	static ArrayList<ParseObject> obj = new ArrayList<ParseObject>();
	
	public static void main(String[] args) {

		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void start() throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.print("쿼리 입력 : ");
		String que = s.nextLine();
		System.out.print("받을 갯수를 입력 : ");
		int num = s.nextInt();
		
		parseMyLocation(que,num);
		printObject();
		
	}
	
	public static void createObject(String name,String address,String number,String distance) {
		
		obj.add(new ParseObject(name,address,number,distance));
		
	}
	
	public static void printObject() {
		
		for(int i = 0;i<obj.size();i++) {
			
			System.out.println("상호명 : "+obj.get(i).getName());
			System.out.println("주소 : "+obj.get(i).getAddress());
			System.out.println("번호 : "+obj.get(i).getNumber());
			System.out.println("집과의 거리 : "+obj.get(i).getDistance());
			System.out.println("========================");
			
		}
	}

	public static void parseMyLocation(String query, int size) throws Exception {

		// https://dapi.kakao.com/v2/local/search/keyword.json?
		// REST API 키 0bf6a910ea5353ba9a0e058b7f553cd9
		// Authorization: KakaoAK ${REST_API_KEY}

		String url = "https://dapi.kakao.com/v2/local/search/keyword.json?";
		String loc = query;
		loc = URLEncoder.encode(loc, "UTF-8");
		url = url + "query=" + loc;
		url = url + "&radius=5000&sort=distance&x=126.8081952&y=37.5665019";
		url = url + "&size=" + size;
		
		System.out.println("최종 url : "+url);
		
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Authorization", "KakaoAK 0bf6a910ea5353ba9a0e058b7f553cd9");

		InputStream is = JiHttpClient.download(url, header);
		String str = JiHttpClient.convert(is, "UTF-8");

		JSONParser jp = new JSONParser();
		JSONObject jo = (JSONObject) jp.parse(str);

		JSONArray jArray = (JSONArray) jo.get("documents");
		JSONObject joMain = null;

		for (int i = 0; i < jArray.size(); i++) {

			joMain = (JSONObject) jArray.get(i);

			String address = (String) joMain.get("address_name");
			String phoneNumber = (String) joMain.get("phone");
			String placeName = (String) joMain.get("place_name");
			String distance = (String) joMain.get("distance");

			createObject(placeName, address, phoneNumber, distance);

		}

	}

}
