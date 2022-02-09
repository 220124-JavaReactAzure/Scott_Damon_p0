package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.exceptions.AuthenticationException;
import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;

public class LoginMenu extends Menu {

	private final CustomerService customerService;
	
	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Login", "/login", consoleReader, router, customerService);
		this.customerService = customerService;
	}
	
	@Override
	public void render() throws Exception {
		System.out.println("Please enter your login information.");
		System.out.print("Username: ");
		String username = consoleReader.readLine();
		System.out.print("Password: ");
		String password = consoleReader.readLine();
		
		try {
			customerService.authenticateCustomer(username, password);
			router.transfer("/dashboard");
		}catch (AuthenticationException e ) {
			System.out.println("Incorrect login information provided. No matching account.");
		}
	}
}
