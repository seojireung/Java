package edu.kh.control.condition.practice;

import java.util.Scanner;

// 실습문제 작성 클래스
public class ConditionPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 한 개 입력하세요 : ");
		int a = sc.nextInt();

		if (a <= 0) {
			System.out.println("양수만 입력해주세요.");
		} else if (a > 0 && a % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}

	}

	public void practice2() {

	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();

		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.printf("%d월은 31일까지 있습니다.", month);
			break;
		case 2:
			System.out.printf("%d월은 28일까지 있습니다.", month);
			break;
		case 4, 6, 9, 11:
			System.out.printf("%d월은 30일까지 있습니다.", month);
			break;
		default:
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		}
	}

	public void practice4() {

	}

	public void practice5() {

	}

}
