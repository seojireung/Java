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
			sum += i; 

			if (i < a) {
				System.out.printf("%d + ", i);
			} else {
				System.out.printf("%d = ", i);
			}
		} //
		/*
		 * 다른 풀이
		 * for (int i = 1; i <= a; i++) { 
		 *      sum += i;
		 *      System.out.printf("%d + ", i); 
		 *      } 
		 *      sum += a;
		 *      System.out.print(a + " = " + sum);
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

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();

		for (int i = 1; i <= a; i++) {
			for (int x = 1; x <= a - i; x++) {
				System.out.print(" ");
			}
			for (int y = 1; y <= i; y++) {
				System.out.print("*");
			}
			for (int y = 2; y <= i; y++) {
				System.out.print("*");
			}
			for (int x = 1; x <= a - i; x++) {
				System.out.print(" ");
			}
			System.out.println("");

		}    
		
/*		//쌤 풀이 빈칸 먼저 출력
 * for문 두개 사용
		for(int row=1; row<=input; row++) {
			for(int col=input-1; col>=1; col--) {
				System.out.print(" ");
			}
			for(int col=1;col<=row*2-1; col++) {
				System.out.println("*");
			}
			}   */
		
		
/* for문 1개, if-else 1개	
		for(int col=1; col<=input+row-1; col++) {
			System.out.print("*");
			if(input-row>=col) {
				System.out.print(" ");
			}else {
				System.out.print("*");
			}
		} */
		
		
	}

	public void practice12() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();
/*
		for (int i = 1; i <= a; i++) {
			System.out.print("*");
		}
		System.out.println("");
		for (int y = 1; y <= a - 2; y++) {
			System.out.print("*");
			for (int x = 1; x <= a - 2; x++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println("");
		}
		for (int i = 1; i <= a; i++) {
			System.out.print("*");
		}
		*/
		//쌤 풀이 첫번째,마지막 줄 행만 *출력하고 나머진 공백 
		for(int row=1; row<=a; row++) {
			for(int col=1; col<=a; col++) {
				if(row==1 || row==a || col==1 || col==a) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			} 
			System.out.println(); // 개행
		} 

	}

	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int a = sc.nextInt();

		int count = 0;

		if (a < 1) {
			System.out.println("자연수만 입력 가능합니다.");
		} else {
			for (int i = 1; i <= a; i++) {
				if (i % 2 == 0 || i % 3 == 0) {
					System.out.print(i + " ");
				}
				if (i % 6 == 0) {
					count++;
				}
			}
			System.out.println("");
			System.out.printf("count : %d", count);
		}
	}

}
