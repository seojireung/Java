package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // DB 연결 의미 + bean(스프링이 관리하는 객체) 등록
public class AjaxDAO {

	@Autowired // bean중에서 타입이 같은 객체를 DI(의존성 주입)
	private AjaxMapper mapper;

	public String selectNickname(String email) {
//		return sqlSession.selectOne("ajaxMapper.selectNickname", email);
		return mapper.selectNickname(email);
	}

	public String selectMemberTel(String nickname) {
		return mapper.selectMemberTel(nickname);
	}

	public int checkEmail(String email) {
		return mapper.checkEmail(email);
	}

	public int checkNickname(String nickname) {
		return mapper.checkNickname(nickname);
	}

	public Member selectMember(String email) {
		return mapper.selectMember(email);
						// 1행 조회
	}

	public List<Member> selectMemberList(String input) {
		return mapper.selectMemberList(input);
	}
	
}
