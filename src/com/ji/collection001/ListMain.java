package com.ji.collection001;

import java.util.ArrayList;
import java.util.Comparator;

//	ArrayList
//		요소를 index로 사용하는 것이 배열과 유사함.
//		저장되는 데이터의 수에 따라 크기가 자동적으로 변경
//		요소가 가득 차게 되면 ArrayList가 알아서 동적으로 크기 증가시키고 반대도 마찬가지로 줄여줌.
//		추천하지 않음) 자료형 섞어서 데이터 넣는거 가능.

//	자료형 통일 <> - generic2
//				- 자료형을 고정하는 역할
//				- 클래스명<자료형의 객체명>				

public class ListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList test = new ArrayList();
		test.add("금요일");
		test.add(20);
		test.add(10.20);
		test.add(true);
		for (Object object : test) { // 자료형 통일 안되어 Object로 .
			System.out.println(object);
		}

		System.out.println("==========");

		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("사과");
		fruits.add("파인애플");
		fruits.add("당근");

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(50);
		al.add(new Integer(100));

		System.out.println(al.get(0));
		System.out.println(al.size());

		System.out.println("=================");
		for (Integer i : al) {
			System.out.println(i);
		}

		al.set(0, 30);
		al.add(2, 90);

		System.out.println("=================");
		for (Integer i : al) {
			System.out.println(i);
		}

		al.remove(0);
		al.add(84);
		al.add(2170);
		al.add(33800);

		System.out.println("=================");
		for (Integer i : al) {
			System.out.println(i);
		}

		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2); // 오름차순
			}

		};

		al.sort(c);
		System.out.println("오름차순으로 ~");
		for (Integer i : al) {
			System.out.println(i);
		}

		Comparator<Integer> c2 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1); // 오름차순
			}

		};
		al.sort(c2);
		System.out.println("내림차순으로 ~");
		for (Integer i : al) {
			System.out.println(i);
		}

	}

}
