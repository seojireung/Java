package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		System.out.println("");
		
		// +추가) 합계
				int sum = korean + english + math;
				
				// +추가) 평균
				double avg = sum / 3.0;
				                 // (double)
	
		/*
		System.out.printf("합계 : " + "%d\n", korean + english + math);
		System.out.printf("평균 : " + "%.1f\n", (korean + english + math)/3.0);
		*/
		
		System.out.println("합계 : " + sum);	
		System.out.println("평균 : " + avg);	
		
		// String result = korean >= 40 && english >= 40 && math >= 40 && (korean + english + math)/3.0 >= 60 ? "합격" : "불합격";
		
		String result = korean >= 40 && english >= 40 && math >= 40 && avg >= 60 ? "합격" : "불합격";
		
		System.out.println(result);
		
		
		
		
		
	}

}
