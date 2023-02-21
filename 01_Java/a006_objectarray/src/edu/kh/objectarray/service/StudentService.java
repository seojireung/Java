package edu.kh.objectarray.service;

import edu.kh.objectarray.dto.Student;

// 기능 제공용 클래스(비즈니스 로직 처리)
public class StudentService {

	// ctrl + shift + o : import 자동 추가
	
	// Student 객체를 참조하는 변수 5개짜리 배열을 생성해서 studentArr가 참조하게 함
	private Student[] studentArr = new Student[5];
	
	// StudentService 기본 생성자
	// view 가 만들어지면서 코드가 해석 될 때 아래 요소들도 생성이 됨
	public StudentService() {
		
		// studentArr 배열의 각 요소는 Student 참조 변수
		studentArr[0] = new Student(3, 5, 17, "홍길동");
		studentArr[1] = new Student(2, 3, 11, "김철수");
		studentArr[2] = new Student(1, 7, 3, "최미영");
	}
	
	// param(parameter) : 매개변수
	
	/** 1. 학생 추가 서비스
	 *  @param grade:int
	 *  @param classRoom:int
	 *  @param number:int
	 *  @param name:String
	 *  
	 *  @return result : boolean (학생 추가 성공 시 true)
	 **/
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		
		// studentArr에서 비어있는 인덱스를 찾아
		// 해당 인덱스에 매개변수를 이용해서 생성된 Student 객체 주소를 대입
		// -> true 반환
		for(int i=0; i<studentArr.length; i++) {
			// 배열 요소가 참조하는 주소가 없을 경우 == 비어있다고 판단
			if (studentArr[i] == null) {
				
			}
		}
		
		// 만약 비어있는 인덱스가 없을 경우
		// -> false 반환
		
		
		
		
		return true; //에러 없애기 위해 true/false 아무거나 씀
	}
	
}
