package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.myPage.model.service.MyPageService;

@SessionAttributes({"loginMember"}) 
// Model에 세팅된 값의 key와 {}에 작성된 값  일치하면 session scope로 이동

@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받음
@Controller // 요청/응답 제어 클래스 + Bean 등록 (IOC)
public class MyPageController {
	
	@Autowired // MyPageService의 자식 MyPageServiceImpl 의존성 주입(DI)
	private MyPageService service;
	
	// 내 정보 페이지로 이동
	@GetMapping("/info")
	public String info() {
		// ViewResolver 설정 -> servlet-context.xml
		return "myPage/myPage-info";
	}

}
