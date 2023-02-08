package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx2 {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		// sc.nextInt()    : 다음 입력되는 정수를 얻어옴
		// sc.next()       : 다음 입력되는 한 *단어*를 얻어옴
		// sc.nextDouble() : 다음 입력되는 실수를 얻어옴
		
		// println이 아닌 print로 출력하는 이유 : 입력시 엔터키를 입력해서. println으로 하면 입력을 줄이 바뀐 상태에서 하게 됨.
		
		System.out.print("이름 : ");
		String inputName = sc.next();
		
		System.out.print("나이 : ");
		int inputAge = sc.nextInt();
		
		System.out.print("키 : ");
		double inputHeight = sc.nextDouble();
		
		// 서지영님은 26세, 키 163.8cm 입니다.
		System.out.printf("%s은 %d세, 키 %.1fcm 입니다.", inputName, inputAge, inputHeight);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
