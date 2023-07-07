package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/search")
	public String searchUser(User userId, Model model) {
		User correctUser = service.searchUser(userId);
		if (correctUser!=null) {
			model.addAttribute("correctUser", correctUser);
			return "searchSuccess";
		}else {
			return "searchFail";
		}
	}
}