package com.ji.collection001;

import java.util.HashMap;
import java.util.Set;

//	Map 계열 (python : dict / Object-C : NSDictionary)

public class MapMain {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		hm.put("아메리카노", 2500);
		hm.put("녹차라떼", 3000);
		hm.put("카페라떼", 3500);
		hm.put("레몬에이드", 5500);
		hm.put("녹차라떼", 7500);
		
		System.out.println(hm.get("녹차라떼"));
		System.out.println("==========");
		
		Set<String> k = hm.keySet();
		for (String ss : k) {
			System.out.println(ss);
			System.out.println(hm.get(ss));
		}
		
		
	}

}
