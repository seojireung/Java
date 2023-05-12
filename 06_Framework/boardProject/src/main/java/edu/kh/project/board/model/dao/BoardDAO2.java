package edu.kh.project.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
@Repository
public class BoardDAO2 {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 게시글 삽입
	 * @param board
	 * @return
	 */
	public int boardInsert(Board board) {
		int result = sqlSession.insert("boardMapper.boardInsert", board);
		// -> sql 수행 후 매개변수 board 객체에는 boardNo 존재 o
		// mapper에서 selectkey로 인해 원본에 대입했기 때문에 boardNo 존재 o 
		
		// 삽입 성공 시
		if(result > 0) result = board.getBoardNo();
		
		return result; // 삽입 성공 시 boardNo, 실패 시 0 반환
	}

	/** 이미지 리스트(여러 개) 삽입
	 * @param uploadList
	 * @return result
	 */
	public int insertImageList(List<BoardImage> uploadList) {
		return sqlSession.insert("boardMapper.insertImageList", uploadList);
	}

	/** 게시글 수정 
	 * @param board
	 * @return rowCount
	 */
	public int boardUpdate(Board board) {
		return sqlSession.update("boardMapper.boardUpdate", board);
	}

	/** 이미지 삭제
	 * @param deleteMap
	 * @return
	 */
	public int imageDelete(Map<String, Object> deleteMap) {
		return sqlSession.delete("boardMapper.imageDelete", deleteMap);
	}

	/** 이미지 수정
	 * @param img
	 * @return rowCount
	 */
	public int imageUpdate(BoardImage img) {
		return sqlSession.update("boardMapper.imageUpdate", img);
	}

	/** 이미지 삽입(1개)
	 * @param img
	 * @return rowCount
	 */
	public int imageInsert(BoardImage img) {
		return sqlSession.insert("boardMapper.imageInsert", img);
	}

	/** 게시글 삭제
	 * @param board
	 * @return
	 */
	public int boardDelete(Board board, int memberNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("board", board);
		map.put("memberNo", memberNo);
		return sqlSession.update("boardMapper.boardDelete", map);
	}

}
