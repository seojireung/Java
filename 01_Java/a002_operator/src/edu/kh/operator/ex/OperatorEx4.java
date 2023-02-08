package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx4 {
	

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in); // Scanner 생성
		
		System.out.println("[홀짝 검사기]");
		
		System.out.print("정수 하나를 입력해주세요 : ");

		int input = sc.nextInt();  // 정수 입력 받아 input이란 변수에 저장
		
		// 삼항 연산자
		// 조건식 ? true인 경우 : false인 경우
//1.		String result = input % 2 == 1 ? "홀수 입니다." : "짝수 입니다.";
		// 문자열 string으로 출력하기 위해 앞에 'String result = ' 입력해야 함
		
//2.		System.out.println(result);
		// 응용1) 절댓값 1 만들기 위해
		// Math.abs(숫자) -> 절대값
//		String result = Math.abs(input) % 2 == 1 ? "홀수 입니다." : "짝수 입니다.";
		// 응용2) 
		// 홀/짝/0 으로 구분하기 위해서.
//		String result = Math.abs(input) % 2 == 1 ? "홀수 입니다." : 짝수 또는 0;
		String result = Math.abs(input) % 2 == 1 ? "홀수 입니다." :
		                                            input ==0 ? "0입니다." : "짝수 입니다.";
		
		System.out.println(result);
		
		
		
		
		
		
	}

}
