package edu.kh.variable;

public class VariableEx4 {
	
	public static void main(String[] args) {
		
		// String(문자열)
		// - 문자열을 저장하는 자료형
		// - 기본 자료형 x
		// - 참조형

		// 문자열 리터럴 표기법 : "" (쌍따옴표)
		
		String str1 = "hello";
		
		System.out.println(str1);
		
		System.out.println(100000000000L);
		
		//출력하고자 하는 값의 리터럴 표기법을 작성
		System.out.println("안녕하세요?");
		
		System.out.println("---------------------------------"); //문자열
		
		// 변수 3개 초기화 (첫 대입)
		String name = "서지영";
		int age = 25;
		char gender = '여';
		
		System.out.println(age + 1); // 정수 + 정수 = 두 수의 합
		System.out.println(name + "입니다"); // 문자열 + 문자열 = 이어쓰기
		System.out.println(name + age); // 문자열 + 정수 = 이어쓰기
		System.out.println(name + age+ gender); // 문자열 + 정수 + 문자형 = 이어쓰기 (자료형 다르면 무조건)
		
		//서지영님은 만 25세 여성입니다. 출력
		System.out.println(name + "님은 만 " + age + "세 " + gender + "성입니다.");
		
		// 자료형 다른 이어쓰기 예외
		// 사칙연산 연산 순위 적용 (왼쪽->오른쪽)
		System.out.println(100 + age + name); // [정수 + 정수] + [문자열] 
		                                      // = 두 정수 합 + 문자열 (이어쓰기)
		
		
		
		
		
		
		
		
	}
	
	

}
