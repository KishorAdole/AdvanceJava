package com.project.service;

import com.project.dto.User;

public interface UserService {
	
	void addUser(User user);
	boolean searchUser(User user);

}
