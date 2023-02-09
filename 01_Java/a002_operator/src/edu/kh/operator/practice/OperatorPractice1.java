package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candies = sc.nextInt();
		
		// 줄 바꿈 방법
		// 내가 쓴 것 
		// System.out.println("");
		// 아래 코드 "\n" 적기
		
		// 1인당 사탕 개수 : 
		// System.out.println("1인당 사탕 개수 : " + candies / people );
		System.out.println("\n1인당 사탕 개수 : " + candies / people );
		
		// 남는 사탕 개수:
		System.out.println("남는 사탕 개수 : " + candies % people );
		
	}

}
