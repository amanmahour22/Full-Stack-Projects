package com.todoproject.springboot.first.web.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class loginController {
	
	private AuthenticationService authenticationService;
	

	public loginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}	
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}
		
		model.put("errorMessage", "Invalid Cridentials! Please Try Again!");
		return "login";
	}	
}
