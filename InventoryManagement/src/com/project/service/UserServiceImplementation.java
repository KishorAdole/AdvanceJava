package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.dto.User;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void addUser(User user) {
		userDao.registerUser(user);
	}

	@Override
	public boolean searchUser(User user) {
		return userDao.verifyUser(user);
	}

}
