package edu.kh.objectarray.view;

import java.util.Scanner;

import edu.kh.objectarray.service.StudentService;

public class StudentView {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	
	// 여기서만 사용할 수 있는 StudentService클래스를 참조하는 새 service 변수 선언(생성자 사용)
	private StudentService service = new StudentService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			System.out.println("----- [학생 관리 프로그램] -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 조회(인덱스)");
			System.out.println("4. 학생 정보 조회(이름)");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("0. 종료");
			System.out.println("--------------------------------");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			System.out.println();
			
			switch(input) {
			case 1 : addStudent(); break;
			case 2 : selectAll(); break;
			case 3 : selectIndex(); break;
			case 4 : selectName(); break;
			case 5 : updateStudent(); break;
			case 0 : System.out.println("[프로그램이 종료됩니다.]");break;
			default : System.out.println("[잘못 입력 하셨습니다.]");
			}
			
			
			System.out.println();
			
			
		}while(input != 0);
		
	}

	/** 1. 학생 정보 추가*/
	private void addStudent() {
		
		System.out.println("[학생 추가]");
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classRoom = sc.nextInt();
		System.out.println("번호 : ");
		int number = sc.nextInt();
		System.out.println("이름 : ");
		int name = sc.nextInt();
		
	}

	private void selectAll() {
		
	}

	private void selectIndex() {
		
	}

	private void selectName() {
		
	}

	private void updateStudent() {
		
	}

	

}
