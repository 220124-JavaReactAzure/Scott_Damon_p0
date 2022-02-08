package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;
import com.revature.scottbank.models.Customer;

public class RegisterMenu extends Menu {

	public RegisterMenu() {

	}

	
	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Register", "/register", consoleReader, router, customerService);
	}

	@Override
	public void render() throws Exception {
		Customer customer = new Customer();
		String firstName = "";
		String lastName = "";
		String email = "";
		String username = "";
		String password = "";
			System.out.print("Enter your first name: ");
			firstName = consoleReader.readLine();
			customer.setFirstName(firstName);
			System.out.print("Enter your last name: ");
			lastName = consoleReader.readLine();
			customer.setLastName(lastName);
			System.out.print("Enter your email: ");
			email = consoleReader.readLine();
			customer.setEmail(email);
			System.out.print("Enter your username: ");
			username = consoleReader.readLine();
			customer.setUsername(username);
			System.out.print("Enter your password: ");
			password = consoleReader.readLine();
			customer.setPassword(password);
	}
}


