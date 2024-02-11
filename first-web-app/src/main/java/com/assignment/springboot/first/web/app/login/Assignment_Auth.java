package com.assignment.springboot.first.web.app.login;

import org.springframework.stereotype.Service;

@Service
public class Assignment_Auth {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("test@sunbasedata.com");
		boolean isValidPassword = password.equalsIgnoreCase("Test@123");
		
		return isValidUserName && isValidPassword;
	}
}
