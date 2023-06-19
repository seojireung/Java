package edu.kh.project.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.kh.project.board.model.dto.Comment;

@Mapper // DB 관련 + bean 등록(IOC)
// mybatis의 어노테이션
public interface CommentMapper {

	// 댓글 목록 조회
	public List<Comment> select(int boardNo);

	// 댓글 삽입
	public int insert(Comment comment);

	// 댓글 삭제
	public int delete(int commentNo);

	// 댓글 수정
	public int update(Comment comment);
}
