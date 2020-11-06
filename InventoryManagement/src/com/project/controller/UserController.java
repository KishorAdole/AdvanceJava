package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dto.User;
import com.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/prepared_registration_form.htm", method = RequestMethod.GET)
	public String registrationForm(ModelMap map) {
		map.put("user", new User());
		return "registration_form";
	}
	
	@RequestMapping(value = "registration.htm", method = RequestMethod.POST)
	public String register(User user, ModelMap map ) {
		userService.addUser(user);
		return "index";
		
	}
	

	@RequestMapping(value = "/prepared_login_form.htm",method = RequestMethod.GET)
	public String loginForm(ModelMap map) {
		map.put("user", new User());
		return "login_form";
	}
	
	@RequestMapping(value = "/login.htm",method = RequestMethod.POST)
	public String login(User user,ModelMap map, HttpSession session) {
		boolean b = userService.searchUser(user);
		if(user.getUserName().equals("admin")) {
			session.setAttribute("user", user);
			return "home";
		}
		if(b) {
			session.setAttribute("user", user); 
			return "user_home";
		}else {
			map.put("user", new User());
			return "login_form";
		}
	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap map) {
		return "logout";
	}
}
