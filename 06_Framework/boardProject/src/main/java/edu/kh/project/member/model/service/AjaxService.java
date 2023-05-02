package edu.kh.project.member.model.service;

public interface AjaxService {

	/** 이메일로 닉네임 조회
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

	/** 닉네임으로 전번 조회
	 * @param nickname
	 * @return tel
	 */
	String selectMemberTel(String nickname);

	/** 이메일 중복 확인
	 * @param email
	 * @return count(0/1)
	 */
	int checkEmail(String email);

	/** 닉네임 중복 확인
	 * @param nickname
	 * @return
	 */
	int checkNickname(String nickname);

}
