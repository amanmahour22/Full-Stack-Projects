package com.assignment.springboot.first.web.app.Customers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("firstName")
public class CustomerController {
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	private CustomerService customerService;
	
	// /todo-list
	@RequestMapping("list-customers")
	public String listAllCustomers(ModelMap model) {
	    List<Customer> customers = customerService.findByUsername("test@sunbasedata.com");
	    model.addAttribute("customers", customers); // Corrected attribute
	    return "listCustomers";
	}
	
	@RequestMapping(value="add-customer", method = RequestMethod.GET)
	public String showNewCustomerPage(ModelMap model) {	    	  
	    Customer customer = new Customer(0, "", "", "", "", "", "", 0);
	    model.put("customer", customer);
	    return "customer";
	}

	
	@RequestMapping(value="add-customer", method = RequestMethod.POST)
	public String addNewCustomer(ModelMap model, @Valid Customer customer, BindingResult result) {   
	    if(result.hasErrors()) {
	        return "customer"; 
	    }
	    customerService.addCustomer(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getAddress(), 
	            customer.getCity(), customer.getState(), customer.getEmail(), customer.getPhone());	    
	    return "redirect:list-customers"; // Redirect to the customer list page
	}
	
	@RequestMapping(value="delete-customer")
	public String deleteCustomer(@RequestParam int id) {	
		// delete Customer
		customerService.deleteById(id);
		return "redirect:list-customers";
	}
	
	@RequestMapping(value="update-customer", method=RequestMethod.GET)
	public String showUpdateCustomerPage(@RequestParam int id, ModelMap model) {	
		// udpate Customer
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping(value="update-customer", method=RequestMethod.POST)
	public String UpdateCustomer(ModelMap model, @Valid Customer customer, BindingResult result) {
		
		if(result.hasErrors()) {
			return "customer";
		}
		
		customerService.updateCustomer(customer);
		return "redirect:list-customers";
	}
}
