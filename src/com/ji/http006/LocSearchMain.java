package com.ji.http006;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ji.http001.JiHttpClient;

public class LocSearchMain {

	// REST API 키 0bf6a910ea5353ba9a0e058b7f553cd9
	// JavaScript 키 8dbf3fd108a4ba9f663ac82d671fce67

	// https://dapi.kakao.com/v2/local/search/keyword.${FORMAT}
	// Authorization: KakaoAK ${REST_API_KEY}

	// 위도(Latitude) / 경도(Longitude)
	// 위도 : 적도 기준으로 북 / 남으로 구분. 적도 기준으로 얼마나 떨어져있나?
	// 북극점 (북위 90도) / 남극점 (남위 90) : (MAX 90)
	// 경도 : 영국 그리니치 천문대를 기준으로 동 / 서로 구분.
	// 날짜변경선이 동경 180도 / 서경 180도 만나는 곳 : (MAX 180)

	// 37.5665019 126.8081952

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Scanner s = new Scanner(System.in);
			System.out.print("검색할 것 : ");
			String search = s.nextLine();

			System.out.print("검색할 횟수 : ");
			int num = s.nextInt();

			search = URLEncoder.encode(search, "UTF-8");

			String addr = "https://dapi.kakao.com/v2/local/search/keyword.json";
			addr += "?query=" + search;
			addr += "&x=126.8081952&y=37.5665019";
			addr += "&radius=5000";
			addr += "&sort=distance";
			addr += "&size=" + num;

			System.out.println("===== 최종 URL =====");
			System.out.println(addr);
			System.out.println("===================");

			HashMap<String, String> header = new HashMap<String, String>();
			header.put("Authorization", "KakaoAK 0bf6a910ea5353ba9a0e058b7f553cd9");

			InputStream is = JiHttpClient.download(addr, header);

			String str = JiHttpClient.convert(is, "UTF-8");

			// 주소, 전화번호, 상호명, 집과의 거리 출력
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

				System.out.println("상호명 : " + placeName);
				System.out.println("주소 : " + address);
				System.out.println("번호 : " + phoneNumber);
				System.out.println("집과의 거리 : " + distance + "m");
				System.out.println("=====================");

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
