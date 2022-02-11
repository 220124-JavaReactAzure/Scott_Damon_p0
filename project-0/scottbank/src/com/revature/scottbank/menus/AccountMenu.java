
package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.util.Logger;
import com.revature.scottbank.util.MenuRouter;
import com.revature.scottbank.exceptions.AuthenticationException;
import com.revature.scottbank.exceptions.InvalidRequestException;
import com.revature.scottbank.models.Account;
import com.revature.scottbank.models.Customer;

public class AccountMenu extends Menu{

	
	public AccountMenu() {
		
	}
	
	public AccountMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("Accountmenu", "/accountmenu", consoleReader, router, accountService);
	}
		
	@Override
	public void render() throws Exception {
		
	
	System.out.print("Enter the name of the account: ");
	
	String accountName = consoleReader.readLine();
	
	System.out.print("Enter the starting balance: ");
	String balanceString = consoleReader.readLine();
	
	
	double balance = Double.valueOf(balanceString);

	
	while(balance < 0) {
		System.out.print("Cannot create a bank account with negative funds.\nEnter the starting balance: ");

		balanceString = consoleReader.readLine();
		balance = Double.valueOf(balanceString);
		
	}
	System.out.println("Starting account balance: $" + balance);
	balance = Double.valueOf(balanceString);
	Account newAccount = new Account(accountName, balance);

	accountService.createAccount(newAccount);

	
	router.transfer("/dashboard");
	}
}
