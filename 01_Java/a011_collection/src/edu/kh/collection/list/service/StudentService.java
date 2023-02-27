package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {
	
	private List<Student> studentList = new ArrayList<Student>(); 
	
	public StudentService() {
		studentList.add(new Student("홍길동", 3, 5, 17, "서울시 중구 남대문로", 'M', 75));
		studentList.add(new Student("김이번", 2, 7, 12, "서울시 서대문구", 'F', 87));
		studentList.add(new Student("이삼범", 1, 4, 25, "서울시 방배동", 'M', 98));
		studentList.add(new Student("박사번", 2, 3, 8, "경기도 남양주시", 'F', 92));
		studentList.add(new Student("백오번", 3, 1, 2, "서울시 노원구", 'M', 70));
	}
	
	/* 학생 정보 추가 서비스
	 * @param ??????
	 * @return ??????
	 * */
	public boolean addStudent(Student std) {
		return studentList.add(std);
		// E add의 boolean return 값은 기본 true!
	}
	
	/* 학생 전체 조회 서비스
	 * @return studentList
	 * */
	public List<Student> selectAll() {
		return studentList;
	}

	
	/** 학생 정보 수정 서비스
	 * @param index
	 * @param std
	 * @return s:Student (수정되기 전 학생 정보)
	 */
	public Student updateStudent(int index, Student std) {
		
		// e2 set(int index, E e) : 
		// 특징1) index에 위치하는 요소를 e로 변경
		// 특징2) 반환은 기존에 있던 요소 e2를 반환함
		
		return studentList.set(index, std); // 변경 전 기존 요소
	}

	/** 학생 정보 제거 서비스
	 * @param index
	 * @return s:Student (제거된 학생 정보)
	 */
	public Student removeStudent(int index) {
		
		// E remove(int index) : index번째 요소를 List에서 제거하여 반환.(지금 하는거)
		
		// E remove(Object o) : List에서 E와 일치하는 요소를 찾아서
		//                      있으면 제거하고 true
		//                      없으면 false 반환
		
		return studentList.remove(index);
		
	}
	
}
