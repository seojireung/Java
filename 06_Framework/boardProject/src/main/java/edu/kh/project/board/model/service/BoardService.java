package edu.kh.project.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.board.model.dto.Board;

public interface BoardService {
	
	List<Map<String, Object>> selectBoardTypeList();
	Map<String, Object> selectBoardList(int boardCode, int cp);
	
	/** 게시글 상세 조회
	 * @param map
	 * @return
	 */
	Board selectBoardList(Map<String, Object> map);
	
	/** 좋아요 하트
	 * @param map
	 * @return result
	 */
	int boardLikeCheck(Map<String, Object> map);
	
	/** 좋아요 처리 서비스
	 * @param paramMap
	 * @return count
	 */
	int like(Map<String, Integer> paramMap);
	
	/** 조회수 증가 서비스
	 * @param boardNo
	 * @return
	 */
	int updateReadcount(int boardNo);
	
	
}
