package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import edu.kh.jdbc.board.dto.Board;
import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;

// 데이터 가공, 트랜잭션 처리
public class BoardService {
	
	private BoardDAO dao = new BoardDAO(); // 명시적 초기화
	
	private CommentDAO commentDao = new CommentDAO();

	/** 게시글 목록 조회 서비스
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectAllBoard() throws Exception{
		Connection conn = getConnection();
		List<Board> boardList = dao.selectAllBoard(conn);
		close(conn);
		return boardList;
	}

	/** 게시글 상세 조회
	 * dao 2개
	 * @param input
	 * @param memberNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int input, int memberNo) throws Exception {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. 게시글 상세 조회 DAO 메서드 호출
		Board board = dao.selectBoard(conn, input);
		
		// 3. 게시글이 조회된 경우
		if(board != null) {
			
			// **************************************************************
			// ** 해당 게시글에 대한 댓글 목록 조회 DAO 호출 **
			List<Comment> commentList = commentDao.selectCommentList(conn, input);
			
			// board에 댓글 목록 세팅
			board.setCommentList(commentList);
			
			// **************************************************************
			
			// 4. 조회수 증가 
			//    단, 게시글 작성자와 로그인한 회원이 다른 경우에만 증가
			if( board.getMemberNo() != memberNo) {
			  // 조회한 게시글 회원 번호 != 로그인한 회원 번호
				
				// 5. 조회수 증가 DAO 메서드 호출(update)
				int result = dao.updateReadCount(conn, input);
				
				// 6. 트랜잭션 제어 처리 + 데이터 동기화 처리
				if(result>0) { // 성공하면
					commit(conn);
					// 조회된 board의 조회수가 0
					// DB의 조회수는 1
					// 	-> 조회 결과인 board의 조회수도 1 증가
					board.setReadCount( board.getReadCount() + 1 );
					
				} else rollback(conn);
			}
		}
		// 7. 커넥션 반환
		close(conn);
		// 8. 결과 반환
		return board;
	}

	/** 게시글 수정 서비스
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(String boardTitle, String boardContent, int boardNo) throws Exception{
													// String 이름 변경 (자료형이 중요함)
		Connection conn = getConnection();
		
		// 게시글 수정 DAO 호출
		int result = dao.updateBoard(conn, boardTitle, boardContent, boardNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 게시글 삭제 서비스
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int boardNo) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	/** 게시글 삽입 서비스
	 * dao 2개
	 * @param boardTitle
	 * @param boardContent
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(String boardTitle, String boardContent, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		// 다음 게시글 번호 생성 --> 10
		int boardNo = dao.nextBoardNo(conn);
		
		// 제목, 내용, 회원번호 + 다음 게시글 번호(10)
		int result = dao.insertBoard(conn, boardTitle, boardContent, memberNo, boardNo);
																			  // 위에서 얻어온 다음 게시글 번호
		if(result>0) { // 성공하면
			commit(conn);
			result = boardNo; // 게시글 번호 담기
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;  // 삽입 성공 시 다음 게시글 번호
						// 실패 시 0
	}

}
