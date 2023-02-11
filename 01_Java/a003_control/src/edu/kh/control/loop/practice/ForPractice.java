package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		}
	}

	public void practice2() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();

		if (input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for (int i = input; i >= 1; i--) {
				System.out.print(i + " ");
			}
		}
	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int a = sc.nextInt();

		int sum = 0;
		//
		for (int i = 1; i <= a; i++) {
			sum += i; // a 아니고 i

			if (i < a) {
				System.out.printf("%d + ", i);
			} else {
				System.out.printf("%d = ", i);
			}
		} //
		/*
		 * 다른 풀이 ************************다시 보기 for (int i = 1; i <= a; i++) { sum += i;
		 * System.out.printf("%d + ", i); } sum += a; System.out.print(a + " = " + sum);
		 */

		System.out.print(sum);

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int a = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int b = sc.nextInt();

		if (a < 1 || b < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		} else if (a < b) {
			for (int i = a; i <= b; i++) {
				System.out.print(i + " ");
			}
		} else if (a > b) {
			for (int x = b; x <= a; x++) {
				System.out.print(x + " ");
			}
		} else {
			System.out.print(a);
		}

	}

	public void practice5() {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int a = sc.nextInt();
		System.out.printf("===== %d단 =====\n", a);

		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", a, i, a * i);
		}

	}

	public void practice6() {

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int a = sc.nextInt();

		if (a < 2 || a > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요");
		} else {
			for (int dan = a; dan <= 9; dan++) {
				System.out.printf("===== %d단 =====\n", dan);
				for (int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d\n", dan, i, dan * i);
				}
			}
		}

	}

	public void practice7() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();

		for (int i = 1; i <= a; i++) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();

		for (int i = a; i >= 1; i--) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	public void practice9() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();

		for (int i = 1; i <= a; i++) {
			for (int x = 1; x <= a - i; x++) {
				System.out.print(" ");
			}
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void practice10() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();

		for (int i = 1; i <= a; i++) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = a; i >= 1; i--) {
			for (int x = 1; x <= i; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void practice11() {

	}

	public void practice12() {

	}

	public void practice13() {

	}

}
