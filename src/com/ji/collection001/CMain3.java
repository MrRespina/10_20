package com.ji.collection001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.ji.student.Student;

public class CMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.print("정보를 확인할 사람의 이름을 입력하세요 : ");
		String name = k.nextLine();
		System.out.println("====================");

		// ArrayList 사용
		ArrayList<Student> student = new ArrayList<Student>();

		student.add(new Student("지병천", 99, 89, 79));
		student.add(new Student("엄홍익", 90, 80, 70));
		student.add(new Student("박유한", 97, 87, 77));
		student.add(new Student("차예나", 66, 77, 68));
		student.add(new Student("조한희", 37, 55, 46));

		for (int i = 0; i < student.size(); i++) {

			if (student.get(i).getName().equals(name)) {

				student.get(i).printInfo();

			}

		}

		k.close();

	}

}
