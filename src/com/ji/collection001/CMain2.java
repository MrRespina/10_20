package com.ji.collection001;

import java.util.ArrayList;
import java.util.Scanner;

import com.ji.student.Student;

public class CMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner k = new Scanner(System.in);
		System.out.print("학생 번호 : ");
		int no = k.nextInt();
		
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student("지병천", 99, 89, 79));
		student.add(new Student("엄홍익", 90, 80, 70));
		student.add(new Student("박유한", 97, 87, 77));
		student.add(new Student("차예나", 66, 77, 68));
		
		student.get(no-1).printInfo();
		System.out.println("==========");
		
		for(int i=0;i<student.size();i++) {
			System.out.println("번지값 : "+student.get(i));
			student.get(i).printInfo();
			System.out.println("=========");
		}

		k.close();
		
	}

}
