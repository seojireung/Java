package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.CommentDAO;

public class CommentService {
	
	private CommentDAO dao = new CommentDAO();

	/** 댓글 등록 서비스
	 * dao 2개
	 * @param comment
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(String comment, int boardNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int commentNo = dao.nextCommentNo(conn);
		
		int result = dao.insertComment(conn, commentNo, comment, memberNo, boardNo);
		
		if (result>0) {
			commit(conn);
			result = commentNo;
		}
		
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 댓글 일치 확인 서비스
	 * @param boardNo
	 * @param memberNo
	 * @return check
	 * @throws Exception
	 */
	public int commentExisCheck(int boardNo, int memberNo) throws Exception {
		Connection conn = getConnection();
		int check = dao.commentExisCheck(conn, boardNo, memberNo);
		close(conn);
		return check;
	}

	/** 댓글 수정 서비스
	 * @param chageComment
	 * @param input 
	 * @return result
	 * @throws Exception
	 */
	public int updateComment(String changeComment, int input) throws Exception {
		Connection conn = getConnection();
		int result = dao.updateComment(conn, changeComment, input);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	/** 댓글 삭제 서비스
	 * @param input
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(int input) throws Exception {
		Connection conn = getConnection();
		int result = dao.deleteComment(conn, input);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
