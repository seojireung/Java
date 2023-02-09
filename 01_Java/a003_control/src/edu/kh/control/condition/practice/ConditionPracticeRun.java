package edu.kh.control.condition.practice;

import java.util.Scanner;

// 실행용 클래스
public class ConditionPracticeRun {

	public static void main(String[] args) {
		
		ConditionPractice cp = new ConditionPractice();

		Scanner sc = new Scanner(System.in);
		
		System.out.print("실행할 예제 번호 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 : practice1(); break;
		case 1 : practice2(); break;
		case 1 : practice3(); break;
		case 1 : practice4(); break;
		case 1 : practice5(); break;
		default : System.out.println("존재하지 않은 예시 번호입니다.");
		}
		
	}
}
