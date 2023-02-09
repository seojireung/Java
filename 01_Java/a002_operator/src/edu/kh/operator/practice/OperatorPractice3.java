package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
	
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
	/*	String result1 = input1 > 0 ? "양수 입니다." : "음수 입니다." ;
		System.out.println(result1);
		
		System.out.println("");
		
		System.out.print("정수 입력 : ");
		int input2 = sc.nextInt();
		
		String result2 = input2 < 0 ? "음수 입니다." : "양수 입니다.";
		System.out.println(result2);
		
		System.out.println("");
		
		System.out.print("정수 입력 : ");
		int input3 = sc.nextInt();
		
		String result3 = input3 > 0 ? "양수 입니다." : 0==0? "0 입니다." : "음수 입니다.";
		System.out.println(result3);
		*/
		
		String result = input == 0 ? "0" : ( input > 0 ? "양수" : "음수" );
		
		System.out.println(result + " 입니다.");
		
		
		
	}

}
