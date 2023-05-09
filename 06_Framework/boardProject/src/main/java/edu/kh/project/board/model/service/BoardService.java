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
	 * @return
	 */
	int boardLikeCheck(Map<String, Object> map);
	
	
}
