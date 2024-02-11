package com.assignment.springboot.first.web.app.Customers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class CustomerService {

	private static List<Customer> customers = new ArrayList<>();
	
	private static int CustomerCount = 0;
	static {
		customers.add(new Customer(++CustomerCount, "Sakshi", "Sharma", "Hno 1", "Delhi", "Delhi", "sam@gmail.com", 10258));
		customers.add(new Customer(++CustomerCount, "Nikhil", "Sharma", "Hno 1", "Delhi", "Delhi", "sam@gmail.com", 10232));
		customers.add(new Customer(++CustomerCount, "Roneet", "Sharma", "Hno 1", "Delhi", "Delhi", "sam@gmail.com", 10267));
		customers.add(new Customer(++CustomerCount, "Jane", "Jane", "Hno 1", "Delhi", "Delhi", "sam@gmail.com", 10244));
		customers.add(new Customer(++CustomerCount, "Tom", "Tom", "Delhi", "Delhi", "Delhi", "sam@gmail.com", 10245));
	}
	
	public List<Customer> findByUsername(String username){
		return customers;
	}
	
	public void addCustomer(int id, String firstName, String lastName, String address, String city, String state, String email, int phone) {
	    Customer customer = new Customer(id, firstName, lastName, address, city, state, email, phone);
	    customers.add(customer); // Add the customer to the customers list
	}
	
	public void deleteById(int id) {
	    Predicate<Customer> predicate = new Predicate<Customer>() {
	        @Override
	        public boolean test(Customer customer) {
	            return customer.getId() == id;
	        }
	    };
	    customers.removeIf(predicate);
	}

	public Customer findById(int id) {
		Predicate<Customer> predicate = new Predicate<Customer>() {
	        @Override
	        public boolean test(Customer customer) {
	            return customer.getId() == id;
	        }
	    };
	    Customer customer = customers.stream().filter(predicate).findFirst().get();
		return customer;
	}

	public void updateCustomer(@Valid Customer customer) {
		deleteById(customer.getId());
		customers.add(customer);
	}

}
