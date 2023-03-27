package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.memeber.model.dto.Member;

/** 회원 전용 화면
 * @author 서지영(이메일/깃헙 주소)
 * @
 */
public class MemberView {
	
	private Scanner sc = new Scanner(System.in);

	private MemberService service = new MemberService();
	
	/**
	 * 회원 기능 메뉴 
	 */
	public void memberMenu() {
	
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n===== 회원 기능 =====\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별)");
				System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)");
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, UPDATE)");
				
				System.out.println("9. 메인메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1: selectMyInfo(); break;
				case 2: selectMemberList(); break;
				case 3: updateMember(); break;
				case 4: updatePassword(); break;
				case 5: 
					if(unRegisterMember()) {
						return; // 호출 했던 mainView에 있는데 membeName으로 돌아감
					}; break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 9: System.out.println("\n===== 메인 메뉴로 돌아갑니다 =====\n") ;break;
				case 0: 
					System.out.println("\n=== 프로그램 종료 ===\n");
					/*new!꿀팁!*/
					// JVM 강제 종료 구문
					// 매개변수는 기본 0, 다른 숫자는 오류를 의미
					System.exit(0);
//					Terminates the currently running Java Virtual Machine.
				
				default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
				sc.nextLine(); // 입력 버퍼에 잘못된 문자열 제거
				input = -1; // while문 종료 방지
			}
			
		} while(input != 9) ;
	}
	
	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {
		System.out.println("\n===== 내 정보 조회 =====\n");
		
		// 회원 번호, 아이디, 이름, 성별(남/여), 가입일
		// Session.loginMember 이용 (로그인 sql에 select 5가지 작성되어 있음-> session이 정보 가지고 있는 상태)
		
		System.out.println("회원 번호 : " + Session.loginMember.getMemberNo());
		System.out.println("아이디 : " + Session.loginMember.getMemberId());
		System.out.println("이름 : " + Session.loginMember.getMemberName());
		if(Session.loginMember.getMemberGender().equals("M")) System.out.println("성별 : 남");;
		if(Session.loginMember.getMemberGender().equals("F")) System.out.println("성별 : 여");;
		System.out.println("가입일 : " + Session.loginMember.getEnrollDate());
	}
	
	/**
	 * 회원 목록 조회
	 */
	private void selectMemberList() {
		System.out.println("\n===== 회원 목록 조회 =====\n");
		
		try {

			// 회원 목록 조회 서비스 호출 후 결과 반환 받기
			List<Member> memberList = service.selectMemberList();
			
			if(memberList.isEmpty()) { // 조회 결과 x // 무조건 실행 될 경우 없지만 리마인드 하려고 작성..
				System.out.println("\n===== 조회 결과가 없습니다. =====\n");
				return;
			}
			
			// 1 user04 유저사 여
			// 2 user03 유저삼 여
			// 3 user02 유저이 남
			// 4 user01 유저일 여
			
			for(int i=0; i<memberList.size(); i++) {
				System.out.printf("%d\t\t%s\t\t%s\t\t%s \n",
						i+1, 
						memberList.get(i).getMemberId(),
						memberList.get(i).getMemberName(),
						memberList.get(i).getMemberGender());
			}
			
		} catch (Exception e) {
			System.out.println("\n***** 회원 목록 조회 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 내 정보 수정
	 */
	private void updateMember() {
		System.out.println("\n===== 내 정보 수정 =====\n");
		// 이름(VARCHAR2) / 성별(CHAR, M/F)
		System.out.print("수정할 이름 : ");
		String memberName = sc.next();
		
		String memberGender = null;
		while(true) {
			System.out.print("수정할 성별(M/F) : ");
			// Java char : 문자 1개
			// DB CHAR : 고정 길이 문자열 (== Java의 String)
			memberGender = sc.next().toUpperCase();
			
			if(memberGender.equals("M")||memberGender.equals("F") ) {
				break;
			}
			System.out.println("[M 또는 F를 입력해주세요]");
		}
		
		try {
			int result = service.updateMember(memberName,memberGender, 
					Session.loginMember.getMemberNo());//로그인 상태니까.
			// Session.loginMember.getMemberNo() : 로그인한 회원의 번호
			// Service 호출 -> DAO 호출 -> UPDATE 수행 -> 결과 행(int)
			
			if(result>0) {
				System.out.println("\n=== 수정 되었습니다 ===\n");
				
				// Service를 호출해서 DB만 수정
				// -> DB와 Java프로그램 데이터 동기화
				Session.loginMember.setMemberName(memberName);
				Session.loginMember.setMemberGender(memberGender);
			} else {
				System.out.println("\n*** 수정 실패 ***\n");
			}
		} catch (Exception e) {
			System.out.println("\n***** 회원 정보 수정 중 예외 발생 *****\n");
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * 비밀번호 변경
	 */
	private void updatePassword() {
		System.out.println("\n===== 비밀번호 변경 =====\n"); 
										// ** 꿀팁! **
		String presentPassword = null; // while문 밖에서도 사용하기 위해서 밖에 변수 선언.
		String newPassword = null;
		String checkNewPassword = null;
		
		while(true) {
		// 현재 비밀번호 입력
			System.out.print("현재 비밀번호 : ");
			presentPassword = sc.next();
		// 새 비밀번호 입력
			System.out.print("새 비밀번호 : ");
			newPassword = sc.next();
		// 새 비밀번호 확인 입력
			System.out.print("새 비밀번호 확인 : ");
			checkNewPassword = sc.next();
		// 같을 때까지 무한 반복
			if(newPassword.equals(checkNewPassword)) {
				break;
			} else { // 아닐 때
				System.out.println("\n*** 입력하신 새 비밀번호를 다시 확인해주세요 ***\n");
			}
		}
		
		try {
			// 서비스 호출(현재 비밀번호, 새 비밀번호, 로그인한 회원 번호)
			int result = service.updatePassword(presentPassword, newPassword,
					Session.loginMember.getMemberNo());
			
			// -> 성공하면 1 / 실패하면 0 -> int형 변수
			if(result>0) { // 1인 경우
				System.out.println("\n=== 비밀번호가 변경되었습니다 ===\n");
			} else { // 0인 경우
				System.out.println("\n*** 현재 비밀번호가 일치하지 않습니다 ***\n");
			}
		} catch (Exception e) {
			System.out.println("\n***** 비밀번호 변경 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 탈퇴
	 * @return true/false
	 */
	private boolean unRegisterMember() {
//		System.out.println(service.createSecurityCode());
		// 보안코드 입력하고 일치하는지 과정은 생략.
		
		System.out.println("\n===== 회원 탈퇴 =====\n");
		
		System.out.print("현재 비밀번호 : ");
		String memberPw = sc.next();
		
		String code = service.createSecurityCode();
		System.out.printf("보안문자 입력 [%s] : ", code);
		String input = sc.next();
		
		// 보안문자 일치여부 확인
		if(!input.equals(code)) {// 일치하지 않으면
			System.out.println("\n*** 보안문자가 일치하지 않습니다 ***\n");
			return false;
		}
		
		while(true) {
			System.out.print("정말 탈퇴 하시겠습니까?(Y/N) : ");
			char check = sc.next().toUpperCase().charAt(0);
			
			if(check=='N') {
				System.out.println("\n=== 탈퇴 취소 ===\n");
				return false; // 메서드 종료
			}
			if(check=='Y') break; // 반복문 종료
			
			// 'Y', 'N' 이 아닌 경우
			System.out.println("\n*** 잘못 입력 하셨습니다 ***\n");
			return false; //확인해보고 필요없음 지우기
		}
		
		try {
			// 회원 탈퇴 서비스 호출
			int result = service.unRegisterMember(memberPw, Session.loginMember.getMemberNo());
			
			if(result>0) {
				System.out.println("\n=== 탈퇴 되었습니다..... ===\n");
				Session.loginMember = null;
				return true;
			}
			
			else System.out.println("\n*** 비밀번호가 일치하지 않습니다 ***\n");
		} catch (Exception e) {
			System.out.println("\n***** 회원 탈퇴 중 예외 발생 *****\n");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
}
