package com.registration.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registration.simple.exception.DuplicateUserException;
import com.registration.simple.exception.InvalidEmailException;
import com.registration.simple.model.User;
import com.registration.simple.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		return "register.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("User")User user) {
		//System.out.println(user);
		try {
			service.addUser(user);
			return "success.jsp";
		} catch (DuplicateUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "duplicate.jsp";
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "invalid_email.jsp";
		}
		
	}
}
