package edu.kh.project.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {
	
	
	public abstract String selectNickname(String email);
	
	String selectMemberTel(String nickname);
	
	// 이메일 중복 검사
	int checkEmail(String email);
	
	// 닉네임 중복 검사
	int checkNickname(String nickname);
	
	// 이메일로 회원 조회
	Member selectMember(String email);
	
	// 이메일 일부 일치하는 모든 회원 조회
	List<Member> selectMemberList(String input);

}
