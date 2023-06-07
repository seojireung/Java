package edu.kh.project.member.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository
public class MemberDAO {
	
	@Autowired 
	private MemberMapper memberMapper; // MemberMapper 인터페이스를 상속 받은 자식 객체
										// -> 자식 객체가 SqlSessionTemplate 이용
	
	/** 로그인
	 * @param inputMember
	 * @return
	 */
	public Member login(Member inputMember) {
		// sqlSession.selectOne("memberMapper.login", inputMember);
		return memberMapper.login(inputMember);
	}

	/** 회원가입
	 * @param inputMember
	 * @return
	 */
	public int signUp(Member inputMember) {
		return memberMapper.signUp(inputMember);
	}
	
	

}
