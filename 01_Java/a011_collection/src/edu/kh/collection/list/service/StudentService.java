package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService { //백엔드
	
	private List<Student> studentList = new ArrayList<Student>(); 
//	private List<Student> studentList = new LinkedList<Student>(); 
	                                         // List 구현 객체마다 장/단점이 있음.
	                                         // Linked는 추가 수정,삭제가 빠름
	
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

	/** 학생 이름 검색 서비스
	 * @param name
	 * @return list:List<Student> 이름이 일치하는 학생 리스트
	 */
	public List<Student> selectName(String name) {
		
		// 1) 검색 결과를 저장할 List<Student> 생성
		List<Student> list = new ArrayList<Student>();
		
		// 2) studentList의 모든 요소를 순차 접근하면서 이름이 일치하는 학생을 
		//    list에서 추가
		
		for(Student s : studentList) {
			if( s.getName().equals(name) ) list.add(s);
		}
		
		// 3) 검색 결과 반환
		return list;
	}

	/** 학생 주소 검색 서비스
	 * @param input
	 * @return list:List<Student> 검색어가 주소에 포함된 학생 리스트
	 */
	public List<Student> selectAddress(String input) {
		
		List<Student> list = new ArrayList<Student>();
		
		for(Student s : studentList) {
			// String.contains("문자열") : String에 "문자열"이 포함되어 있으면 true 반환
			if( s.getAddress().contains(input) ) list.add(s);
		}
		return list;
	}

	/** 학년별 조회
	 * @param grade
	 * @return list:List<Student> grade와 학년이 같은 학생 리스트
	 */
	public List<Student> selectGrade(int grade) {
		
		List<Student> list = new ArrayList</*Student*/>(); 
		                        // 제네릭의 타입 추론 : ArrayList< > 안 생략 가능
		                        // - 생성되는 컬렉션 객체의 제네릭을 별도 작성하지 않아도
		                        //   참조 변수의 제네릭을 통해 제한되는 타입을 유추(추론)
		
//		String g = Integer.valueOf(grade).toString();
		
		for(Student s : studentList) {
			if(s.getGrade()==(grade)) list.add(s);
		}
		
		
		return list;
	}

	/** 성별 조회
	 * @param inputGender
	 * @return list:List<Student> inputGender의 학생 리스트
	 */
	public List<Student> selectGender(char inputGender) {
		
		List<Student> list = new ArrayList<>();
		
		for(Student s : studentList) {
			if (s.getGender() == inputGender) {
				list.add(s);
		    }
		}
		return list;
	}

	/**
	 * 성적 순서 조회 서비스
	 * @return Collections.sort(studentList)
	 */
	public List<Student> sortScore() {
		
		// studentList 정렬 (score 내림 차순)
		// - Collections 클래스 : 컬렉션에 도움되는 유용한 기능을 모은 클래스
		
		// - Comparable<T> 인터페이스
		//   -> 객체의 기본 정렬 기준을 제공하는 인터페이스
		
		// <?> : 어떤게 작성될지 모름 == 아무거나 작성 가능
		// <?> void Collections.sort(List<?> list)
		
		Collections.sort(studentList);
		// studentList에 저장된 객체 Student의
		// 오버라이딩된 compareTo() 메서드를 이용해서 정렬
		// -> 현재 큰 숫자가 오른쪽으로 이동하도록 오버라이딩 됨
		// -> 오름차순 정렬
		
		// void Collections.reverse(List<?> list)
		// - list 순서를 반대로 뒤집음
		// ->  오름차순 --> 내림차순
//		Collections.reverse(studentList);
		
		
		
		
		return studentList;
	}
	
	
	
	
}
