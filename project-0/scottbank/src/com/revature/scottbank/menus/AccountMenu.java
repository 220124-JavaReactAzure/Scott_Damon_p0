/*
package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;
import com.revature.scottbank.exceptions.InvalidRequestException;
import com.revature.scottbank.models.Customer;

public class AccountMenu extends Menu{
	
	public AccountMenu() {
		
	}
	
	public AccountMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Accountmenu", "/accountmenu", consoleReader, router, customerService);
	}
		
	@Override
	public void render() throws Exception {
		
		System.out.print("Enter the name of the account you wish to create: ");
		String accountType = consoleReader.readLine();
		CreateAccount = createNewAccount(accountType);
	}

}
	*/