package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("학년(정수) : ");
		int grade = sc.nextInt();
		System.out.print("반(정수) : ");
		int classs = sc.nextInt();
		System.out.print("번호(정수) : ");
		int num = sc.nextInt();
		System.out.print("성별(남학생/여학생) : ");
		String gender = sc.next();
		System.out.print("성적(소수점 아래 둘째 자리까지 : ");
		double testGrade = sc.nextDouble();
		
		System.out.println("");
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.", grade, classs, num, name, gender, testGrade);
		
	}

}
