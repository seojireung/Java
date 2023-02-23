package edu.kh.polymorphism.ex2.dto;

// 추상 클래스(abstract class)
// - 추상 메서드가 포함된 클래스
// 단, 추상 메서드가 없어도 추상 클래스가 될 수 있다!
public abstract class Animal extends Object {
	                // 미작성 시 컴파일러가 자동 추가
	// 추상화, 캡슐화
	
	// 필드
	private String type; // 종(양서류, 포유류, 파충류...)
	private String eatType; // 식성
	
	// 생성자
	public Animal() { // 기본 생성자 _ 다른 생성자 있으면 자동 추가x -> new와 같은 기능 구현 안됨
		super(); // 부모 생성자 호출
		         // 각 메소드마다 있음
		         // 미작성 시 컴파일러가 자동 추가
	} 
	
	public Animal(String type, String eatType) { // 매개 변수 생성자 : 매개 변수를 이용해서 필드 값을 초기화 할 때 사용.

		this.type = type;
		this.eatType = eatType;
	}
	
	// 메서드
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getEatType() {
		return eatType;
	}
	
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	// String Object.toString()
	// - 객체가 가지고 있는 필드를 하나의 문자열로반환하는 용도의 메서드.
	//   (자식이 오버라이딩해서 사용하길 권장)
	// - 오버라이딩 x -> 패키지명+클래스명@해시코드 문자열로 반환함
	@Override // Annotation-검사해줘(컴퓨터용 언어)
	public String toString() {
		return type + " / " + eatType;
	}
	
	// 추상 메서드 (미완성된 메서드)
	// -> 상속 받은 자식 클래스에 반드시 오버라이딩 해야한다! (오버라이딩 강제화)
	// --> 추상 메서드를 포함한 클래스는 반드시 abstract class 여야만 한다.
	public abstract void breath(); 

	
	
	
	
}
