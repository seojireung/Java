package edu.kh.polymorphism.ex1.dto;

public class Truck extends Car {
	
	private double weight; // 적재량
	
	public Truck() {
		super(); // 미작성 시 컴파일러가 자동 추가
	}

	public Truck(int wheel, int seat, String fuel, double weight) {
		super(wheel, seat, fuel); // Car의 매개변수 불러옴
		
		this.weight = weight;
		
	}

	// getter / setter
	// 부모(Car)는 만들어져 있으니까 자식 것만.
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	// Car.toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + " / " + weight;
	}
	
	public void loading() {
		System.out.println("물건을 많이 실을 수 있다.");
	}
	
	
	
	
	
	
}
