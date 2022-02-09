package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;
import com.revature.scottbank.exceptions.InvalidRequestException;
import com.revature.scottbank.models.Customer;

public class RegisterMenu extends Menu {

	public RegisterMenu() {

	}

	
	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Register", "/register", consoleReader, router, customerService);
	}
		
	@Override
	public void render() throws Exception {
		
			System.out.print("Enter your first name: ");
			String firstName = consoleReader.readLine();
			
			System.out.print("Enter your last name: ");
			String lastName = consoleReader.readLine();
			
			System.out.print("Enter your email: ");
			String email = consoleReader.readLine();
			
			System.out.print("Enter your username: ");
			String username = consoleReader.readLine();
			
			System.out.print("Enter your password: ");
			String password = consoleReader.readLine();
			
			String customerId = "";
			
			Customer customer = new Customer(customerId, firstName, lastName, email, username, password);
			try {
				customerService.registerNewCustomer(customer);
			}catch (InvalidRequestException e) {
				System.out.println("Invaid data entered please try again\n\n\n");
				
				router.transfer("/register");
			}
			router.transfer("/dashboard");
		}
}


