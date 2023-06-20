package com.kh.test.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.user.model.dao.UserMapper;
import com.kh.test.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;

	@Override
	public User searchUser(User userId) {
		return mapper.searchUser(userId);
	}
}
