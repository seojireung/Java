package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ConditionEx {
	
	public void test1() {		
		System.out.println("test1() 수행");	
	}
	
	public void test2() {		
		System.out.println("test2() 수행");	
	}
	
	public void test3() {		
		System.out.println("test3() 수행");	
	}

	// if 예시 1번
	public void ex1( ) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		  /*조건식*/
		if(input > 0) {
			// 조건식이 true인 경우에만 if문 {} 내부 코드가 수행된다!
			System.out.println("양수 입니다.");	
			System.out.println("ex1() 종료");	
		} 
		
		if(input < 0) {
			System.out.println("음수 입니다.");
			System.out.println("ex1() 끝!");
		}
	
		
	}
	
	// if 예시 2번  (if - else)
	public void ex2() {
		// 조건식이 true이면 if문 수행
		// false이면 else문 수행
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수 입니다.");
		} else {
			//System.out.println("음수 입니다.");
			
			// [중첩 if문]
			if(input==0) {
				System.out.println("0 입니다.");
			} else {
				System.out.println("음수 입니다.");
			}
		
		}
		
	}
	
	
	// if 예시 3번 : if - else if - else
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[홀짝 판별기]");
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 홀수, 짝수, 0
		if(input==0) {
			System.out.println("0은 홀/짝을 구분할 수 없습니다.");
			
		} else if(Math.abs(input) % 2 == 1) {
			    //절대값
			System.out.println("홀수 입니다.");
			
		} else {
			System.out.println("짝수 입니다.");
		}
	
		
	}
	
	
	// if 예시 4번 
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계절을 알고 싶은 달(월)을 입력해주세요 : ");
		int input = sc.nextInt();
		
		// 조건문 결과를 저장할 문자열 변수 선언 먼저
		String result; 

		if(input >= 3 && input <= 5) {// 3,4,5
       // input==3 || input==4 || input==5 도 가능하지만 김
			result = "봄";
		} else if (input >= 6 && input <= 8) {
			result = "여름";
		} else if (input >= 9 && input <= 11) {
			result = "가을";
		} else if (input == 12 || input==1 || input==2) {
			result = "겨울";
		} else {
			result = "잘못 입력하셨습니다.";
		}
		// if - else if - else 를 거치게 되면
		// 무조건 result에 값이 하나 저장되어 있다!
		System.out.println(result);
		
	}
	
	// if 예시 5번 
	public void ex5() {
		// 나이를 입력 받아
		// 13세 이하면 "어린이"
		// 13세 초과 19세 이하면 "청소년"
		// 19세 초과 "성인" 출력
		// (0세 이하는 생각하지 않음)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력해주세요 : ");
		int input = sc.nextInt();
		
		String result;
		
		/* 내가 쓴 것 (0세 이하 고려)
		if (input <= 13 && input > 0) {
			result = "어린이";
		} else if (input > 13 && input <= 19) {
			result = "청소년";
		} else if (input > 19) {
			result = "성인";
		} else {
			result = "";
		}
		*/
		
		if (input <= 13) {
			result = "어린이";
		}/* else if (input > 13 && input <= 19) { */
		 // 더 간단하게 적으려면
		    else if (input <= 19) {
			result = "청소년";
		}  else {
			result = "성인";
		}
		
		System.out.println(result);
		
	}
	
	// if 예시 6번
	public void ex6() {
		// 놀이기구 탑승 제한 검사
		// 나이가 12세 이상, 키 140.0cm 이상일 경우에만 탑승 가능
		// 나이가 12세 미만 : "적정 연령이 아닙니다."
		// 키 140.0cm 미만 : "적정 키가 아닙니다."
		// 나이를 0세 미만 또는 100세 초과 입력 시 : "잘못 입력하셨습니다."
		
		// [실행 화면]
		// 나이 입력 : 15
		// 키 입력 : 170.5
		// 탑승 가능

		// 나이 입력 : 10
		// 키 입력 : 170.5
		// 적정 연령이 아닙니다.
		
		// 나이 입력 : 12
		// 키 입력 : 135.3
		// 적정 키가 아닙니다.
		
		// 나이 입력 : 120
		// 키 입력 : 183.3
		// 잘못 입력하셨습니다.

		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		// 풀이) 실수형 변수 double 까먹음!!
		double height = sc.nextDouble();
		
		String a;
		
		
		//내가 쓴 것
		/*
		 if (age <= 100 && age >= 12 && height >= 140.0) {
			a = "탑승 가능";
		} else if (age < 12) {
			a = "적정 연령이 아닙니다.";
		} else if (height < 140.0) {
			a = "적정 키가 아닙니다.";
		} else {
			a = "잘못 입력 하셨습니다.";
		}
		*/
		
		// 풀이) 효율 + 모두 만족 (잘못 입력한 경우 먼저 생각)
		// 내가 쓴 것과 비교 : 절대 안되는 조건부터 제치는게 더 효율적임.
		if (age < 0 || age > 0) {
			a = "잘못 입력하셨습니다";
		} else if (age< 12) {
			a = "적정 연령이 아닙니다.";
		} else if (height < 140.0) {
			a = "적정 키가 아닙니다.";
		} else {
			a = "탑승 가능";
		}
		
		System.out.println(a);
		
		
	}
	
	// if 예시 6번 업그레이드
	public void ex7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		String result;
		
		//나이를 입력 받자마자 검사
		if(age<0 || age > 100) {
		result = "잘못 입력 하셨습니다.";
		} else if (age < 12) {
			result = "적정 연령이 아닙니다.";
		} else {
			// else 내부에서는 age가 정상 입력으로 판단됨
			// -> age 정상 일 때 키 판단
			// { } 범위 잘 쓰기!!!
			
		    System.out.print("키 입력 : ");
			double height = sc.nextDouble(); 
			
			//변수 하나 추가 설정
			if(height < 100.0 || height > 220.0) {
	 			result = "잘못 입력 하셨습니다.";
			} else if (height < 140.0){
				result = "적정 키가 아닙니다.";
			} else {
				result = "탑승 가능";
			}
			
		}
		
		System.out.println(result);
		
		
	}
	
	
}
