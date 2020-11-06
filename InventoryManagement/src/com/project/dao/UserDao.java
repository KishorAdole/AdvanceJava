package com.project.dao;

import com.project.dto.User;

public interface UserDao {
	
	void registerUser(User user);
	boolean verifyUser(User user);

}
