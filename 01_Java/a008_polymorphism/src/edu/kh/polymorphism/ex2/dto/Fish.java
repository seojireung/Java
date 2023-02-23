package edu.kh.polymorphism.ex2.dto;

public class Fish extends Animal{

	private int fin; // 지느러미 개수
	
	public Fish() { }

	public Fish(String type, String eatType, int fin) {
		super(type, eatType);
		this.fin = fin;
	}

	// getter / setter
	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	// toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + " / " + fin;
	}

	// 상속 받은 추상 메서드 오버라이딩 강제화
	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다.");
	}
	
	
	
}
