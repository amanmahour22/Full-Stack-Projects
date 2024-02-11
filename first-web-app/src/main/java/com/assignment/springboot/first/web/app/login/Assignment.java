package com.assignment.springboot.first.web.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("firstName")
public class Assignment {
	
	private Assignment_Auth assignment_Auth;

	public Assignment(Assignment_Auth assignment_Auth) {
		super();
		this.assignment_Auth = assignment_Auth;
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String assignment() {
		return "login";
	}	
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String assignment(@RequestParam String name, @RequestParam String password, ModelMap model) {      
	    if(assignment_Auth.authenticate(name, password)) {
	        model.put("name", name);
	        return "redirect:list-customers"; // Redirect to the customer list page
	    }       
	    model.put("errorMessage", "Invalid Credentials! Please Try Again!");
	    return "login";
	}  	
}
