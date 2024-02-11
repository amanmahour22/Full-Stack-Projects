package com.todoproject.springboot.first.web.app.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("aman");
		boolean isValidPassword = password.equalsIgnoreCase("mahour");
		
		return isValidUserName && isValidPassword;
	}
}
