package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.board.model.service.CommentService;
import edu.kh.jdbc.common.Session;

public class CommentView {

	private Scanner sc = new Scanner(System.in);

	private CommentService service = new CommentService();

	/**
	 * 댓글 메뉴
	 * 
	 * @param boardNo(상세 조회 중인 게시글 번호)
	 */
	public void commentMenu(int boardNo) {

		int input = -1;

		try {
			System.out.println("\n=== 댓글 기능 ===\n");
			System.out.println("1) 댓글 등록");
			System.out.println("2) 댓글 수정");
			System.out.println("3) 댓글 삭제");

			System.out.println("0. 댓글 기능 종료");

			System.out.print("\n선택 : ");
			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
	            case 1: insertComment(boardNo);  break; // 댓글 등록
	            // !wq가 입력 될 때까지 댓글 내용을 입력 받고
	            // 내용, 게시글 번호, 로그인 회원 번호를 이용해 
	            // 댓글 삽입 서비스 호출
	            
		        case 2: updateComment(boardNo); break; // 댓글 수정
	            // 댓글 번호를 입력 받아서
	            // 1) 해당 댓글이 현재 게시글의 댓글이며
	            //    로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
	            
	            // 2-1) 1번 결과가 맞지 않으면
	            // 		작성한 댓글만 수정할 수 있습니다
	            // 2-2) 1번 결과가 맞으면
	            // 		!wq가 입력될 때 까지 내용 입력 후 
	            //		댓글번호, 내용을 이용해 댓글을 수정하는 서비스 호출
	            
		        case 3: deleteComment(boardNo); break; // 댓글 삭제
	            // 1) 해당 댓글이 현재 게시글의 댓글이며
	            //    로그인한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
	            
	            // 2-1) 1번 결과가 맞지 않으면
	            // 		작성한 댓글만 삭제할 수 있습니다
	            // 2-2) 맞으면 "정말로 삭제 하시겠습니까?(Y/N) : "출력 후
	            // 		Y 입력 시 : 삭제 서비스 호출(댓글번호)
	            // 		N 입력 시 : 취소되었습니다
	            
				case 0: return;
				default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
			}

		} catch (InputMismatchException e) {
			System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
			sc.nextLine();
		}

	}
	
	/** 댓글 등록 (INSERT)
	 * ?????????? 댓글 등록하고 보이게 추가??????????
	 * @param boardNo
	 */
	private void insertComment(int boardNo) {
		System.out.println("\n=== 댓글 등록 ===\n");
		
		StringBuffer sb = new StringBuffer();
		System.out.println("<!wq 입력 시 종료>");
		System.out.println("댓글 내용 : ");
		while(true) {
			String str = sc.nextLine();
			if (str.equals("!wq")) break;
			sb.append(str);
			sb.append("\n");
		}
		
		try {
			int result = service.insertComment(sb.toString(), boardNo,
					Session.loginMember.getMemberNo());
			if(result>0) {
				System.out.println("\n=== 댓글이 등록되었습니다 ===\n");
			} else System.out.println("\n*** 댓글 등록 실패 ***\n");
		} catch (Exception e) {
			System.out.println("\n***** 댓글 등록 중 예외 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	/** 댓글 수정
	 * @param boardNo
	 */
	private void updateComment(int boardNo) {
		System.out.println("\n=== 댓글 수정 ===\n");
		
		System.out.print("수정할 댓글 번호 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		try {

			// 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인 서비스 호출
			int check = service.commentExisCheck(boardNo, Session.loginMember.getMemberNo());

			if (check == 0) {
				System.out.println("\n*** 작성한 댓글만 수정할 수 있습니다 ***\n");
			} else {
				System.out.println("<!wq 입력 시 종료>");
				System.out.println("수정할 댓글 입력 : ");
				StringBuffer sb = new StringBuffer();
				while (true) {
					String str = sc.nextLine();
					if (str.equals("!wq"))
						break;
					sb.append(str);
					sb.append("\n");
				}
			int result = service.updateComment(sb.toString(), input);
			
			if(result>0) System.out.println("\n=== 댓글 수정 성공! ===\n");
			else System.out.println("\n*** 댓글 수정 실패 ***\n");
			}
		} catch (Exception e) {
			System.out.println("\n***** 댓글 수정 중 오류 발생 *****\n");
			e.printStackTrace();
		}
	}
	
	/** 댓글 삭제
	 * @param boardNo
	 */
	private void deleteComment(int boardNo) {
		System.out.println("\n=== 댓글 삭제 ===\n");
		
		System.out.print("삭제할 댓글 번호 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		try {
			// 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인 서비스 호출
			int check = service.commentExisCheck(boardNo, Session.loginMember.getMemberNo());

			if (check == 0) {
				System.out.println("\n*** 작성한 댓글만 삭제할 수 있습니다 ***\n");
			} 
			
			int result = service.deleteComment(input);
			
			if(result>0) System.out.println("\n=== 댓글 삭제 성공! ===\n");
			else System.out.println("\n*** 댓글 삭제 실패 ***\n");
			
		} catch(Exception e) {
			System.out.println("\n***** 댓글 삭제 중 오류 발생 *****\n");
			e.printStackTrace();
		  }
	}

}
