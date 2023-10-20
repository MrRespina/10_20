package com.ji.collection001;

import java.util.HashSet;

//	set계열
//		가변사이즈, 중복 데이터 자동 삭제(같은 객체 내에 여러개 들어가면 하나만 남음/), 순서 랜덤.
//		HashSet, tresSet,... > 그닥 유용하지가 않다.

public class SetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hs = new HashSet<String>();
		hs.add("ㅁㅁ");
		hs.add("ㅎㅎ");
		hs.add("ㄹㄹ");
		hs.add("ㅁㅁ");
		hs.add("ㄹㄹ");
		hs.add("ㅈㅈ");
		
		System.out.println(hs);
		System.out.println(hs.size());
		
		for (String ss : hs) {
			System.out.println(ss);
		}

	}

}
