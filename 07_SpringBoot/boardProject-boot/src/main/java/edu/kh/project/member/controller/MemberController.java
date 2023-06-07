package edu.kh.project.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
@SessionAttributes({"loginMember"})
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping("/login")
	public String login(Member inputMember, Model model
							, @RequestHeader(value="referer") String referer
							, @RequestParam(value="saveId", required=false)String saveId
							, HttpServletResponse resp
							, RedirectAttributes ra) {
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		// DB 조회 결과 확인
//			System.out.println(loginMember);
		
		// 로그인 결과에 따라 리다이렉트 경로를 다르게 지정
		String path = "redirect:";
		
		if(loginMember != null) { // 로그인 성공 시
			path += "/"; // 메인 페이지로 리다이렉트
			
			// 1) model에 로그인한 회원 정보 추가
			model.addAttribute("loginMember", loginMember);
			// -> 현재는 request scope
//			
//			// 쿠키 생성(해당 쿠키에 담을 데이터를 K:V로 지정)
//			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
//			
//			if(saveId != null) { // 체크 되었을 때
//				// 한달 동안 유지되는 쿠키 생성
//				cookie.setMaxAge(60 * 60 * 24 * 30); // 초 단위 지정
//				
//			}else { // 체크 안되었을 때
//				// 0초 동안 유지되는 쿠키 생성
//				// -> 기존 쿠키를 삭제
//				cookie.setMaxAge(0);
//			}
//	
//			// 클라이언트가 어떤 요청을 할 때 쿠키가 첨부될 경로(주소)를 지정
//			cookie.setPath("/"); // localhost/ 이하 모든 주소
//								 // ex) / , /member/login, /member/logout 등
//								 // 	모든 요청에 쿠키 첨부
//			
//			// 응답 객체(HttpServletResponse)를 이용해서
//			// 만들어진 쿠키를 클라이언트에게 전달
//			resp.addCookie(cookie); 
			
			// ------------------------------------------
			
		}else { // 로그인 실패 시
			path += referer; // HTTP Header - referer(이전 주소)
			
			// addFlashAttribute : 잠시 Session에 추가 (결과적으로는 request scope임)
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		return path;
	}
	
	   // 로그아웃
	   @GetMapping("/logout")
	   public String logout(SessionStatus status, HttpSession session) {
	      status.setComplete(); 
	      return "redirect:/";
	   }
	   
	   // 회원 가입 진행
		@PostMapping("/signUp")
		public String signUp(Member inputMember
							, String[] memberAddress
							, RedirectAttributes ra) {
											// 파라미터 name과 매개변수명 같아서 앞에
											// @RequestParam("memberAddress") 생략.
			// 12345^^^서울시^^^2층
			// 주소 구분자를 , -> ^^^ 변경
//			String addr = inputMember.getMemberAddress().replaceAll(",","^^^");
//			inputMember.setMemberAddress(addr);
			// -> 클라이언트가 , 를 직접 입력하면 문제 발생
			
			// 만약 주소를 입력하지 않은 경우 (,,) -> null로 변경
			if(inputMember.getMemberAddress().equals(",,")) {
				inputMember.setMemberAddress(null);
			}else {
				//String.join("구분자", String[]);
				// 배열의 요소를 하나의 문자열로 변경
				// 단, 요소 사이에 "구분자" 추가
				String addr = String.join("^^^", memberAddress);
				inputMember.setMemberAddress(addr);
			}
			
			// --- DB에 회원 정보 insert ---
			
			// 회원 가입 서비스 호출
			// (DB에 DML 수행 시 성공 행의 개수(int형) 반환)
			int result = service.signUp(inputMember);
			
			// 가입 성공 여부에 따라 주소 결정
			String path = "redirect:";
			String message = null;
			
			if(result>0) { // 가입 성공
				path += "/"; // 메인 페이지
				message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";
			} else { // 가입 실패
				// 회원 가입 페이지
//				path += "/member/signUp"; // 절대 경로
				path += "signUp"; // 상대 경로
				
				message = "회원 가입 실패!";
			}
			// 리다이렉트 시 session에 잠깐 올라갔다 내려오도록 세팅
			ra.addFlashAttribute("message", message);
			
			return path;
		}
		
	

}
