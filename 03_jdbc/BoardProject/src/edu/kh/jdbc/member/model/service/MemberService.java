package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.memeber.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 회원 목록 조회
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList() throws Exception{
		Connection conn = getConnection();
		List<Member> memberList = dao.selectMemberList(conn);
		close(conn);
		
		return memberList;
	}

	/** 회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberName, String memberGender, int memberNo)  throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn,memberName, memberGender,memberNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close (conn);
		
		return result;
	}

	/** 비밀번호 수정
	 * @param presentPassword
	 * @param newPassword
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(String presentPassword, String newPassword, int memberNo) 
			throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, presentPassword, newPassword, memberNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 숫자 6자리 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		
		// String : 불변성
		// StringBuffer : 가변성
		
		Random ran = new Random(); // 난수 생성 객체
		
		for(int i=0; i<6; i++) {
			int x = ran.nextInt(10); // 0이상 10미만 정수 반환
			code.append(x); // StringBuffer 마지막에 추가(뒤에 이어 붙임)
		}
		
		return code.toString(); // 랜덤 발생한 6자리 숫자를 코드로 String화 해서 반환.
	}

	/** 회원 탈퇴
	 * @param memberPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int unRegisterMember(String memberPw, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.unRegisterMember(conn, memberPw, memberNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
}
