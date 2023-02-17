package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {

		int[] arr = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
			if (i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.printf("짝수 번째 인덱스 합 : %d", sum);

	}

	public void practice2() {

		int[] arr = new int[9];
		int sum = 0;
		int x = 9;

			for (int i = 0; i<arr.length; i++) {
				arr[i] = x--;
				System.out.print(arr[i] + " ");
				if (i % 2 == 1) {
					sum += arr[i];
				}
		}
		System.out.println();
		System.out.printf("홀수 번째 인덱스 합 : %d", sum);

	}

	public void practice3() {

		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int index = 0;
		boolean flag = true;

		for (int i = 0; i < 5; i++) {
			System.out.printf("입력 %d : ", i);
			int input = sc.nextInt();
			arr[i] = input; // 입력 받음 [5 8 9 10 4]
		}
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();
		for (int i = 0; i < 5; i++) {
			if (search == arr[i]) {
				index = i;
				flag = false;
				System.out.println("인덱스 : " + i);
				break;
			}
		}
		if (flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5() { // ******** 문자열 입력 받아 하나하나 char배열에 대입하는 법?
		// 입력 받은 문자열 변수 선언?
		//

		/*
		 * Scanner sc = new Scanner(System.in); char[] word; boolean flag = true; int
		 * count = 0; int index = -1;
		 * 
		 * System.out.println("문자열 : ");
		 * 
		 * for(int i=0; i<word.length; i++) { String a = sc.next(); // word[i] = ;
		 * System.out.print(a); } System.out.println(); System.out.print("문자 : ");
		 * String target = sc.next(); for(int i=0; i<word.length; i++) {
		 * if(target.equals(word[i])) { index = i;
		 * //System.out.print("%s에 %d가 존재하는 위치(인덱스) : ", );// 사용 위치, %s 어떻게 표현? count++;
		 * 
		 * } System.out.printf("%d 개수 : %d", target, count); }
		 */

	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int sum = 0;

		int[] arr = new int[num];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			int input = sc.nextInt();
			arr[i] = input;
			sum += input;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("총 합 : " + sum);

	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String pNum = sc.next();
		char[] arr = new char[pNum.length()];
		char[] copy = new char[pNum.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = pNum.charAt(i);
			if (i <= 7) {
				copy[i] = arr[i];
			} else {
				copy[i] = '*';
			}
			System.out.print(copy[i]);
		}
	}

	public void practice8() { // 마지막 , 빼는 방법..?
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("정수 : ");
			int input = sc.nextInt();
			if (input % 2 == 0 || input < 3) {
				System.out.println("다시 입력하세요");
			} else {
				int[] arr = new int[input];
				for (int i=0; i < input/2+1; i++) {
					arr[i] = i + 1;
					System.out.print(arr[i] + ", ");
				}
				for (int x=input/2+1; x>1; x--) {
					arr[x] = x-1;
					System.out.print(arr[x] + ", ");
				}
			} break;
		}
	}

	public void practice9() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i] + " ");
		}
		

	}

	public void practice10() {

	}

	public void practice11() {
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int x=0; x<i; x++) {
				if(arr[i]==arr[x]) {
					i--; //해당 인덱스 i 랜덤 다시 돌리기 위해.
				}
			}
		}
	    for (int p=0; p<arr.length; p++) {
	    	System.out.print(arr[p] + " ");
	    }

	}

	public void practice12() {

	}

	public void practice13() {

	}

	public void practice14() {

	}

	public void practice15() {

	}

	public void practice16() {

	}

	public void practice17() {

	}

	public void practice18() {

	}

	public void practice19() {

	}

	public void practice20() {

	}

	public void practice21() {

	}

	public void practice22() {

	}

	public void practice23() {

	}

	public void practice24() {

	}

	public void practice25() {

	}

}
