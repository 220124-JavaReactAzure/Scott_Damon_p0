package com.revature.scottbank.menus;
import com.revature.scottbank.models.Account;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.util.LinkedList;
import com.revature.scottbank.util.List;
import com.revature.scottbank.util.MenuRouter;

import java.io.BufferedReader;

public class Deposit extends Menu {
	
	AccountService as;
	public Deposit(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
	super("Deposit", "/deposit", consoleReader, router, accountService);
	as = accountService;
}
	
	public void render() throws Exception {

		double amount = 0.0;
		List<Account> newList = new LinkedList<>();
		newList = as.findAllBankAccounts();
		if (newList.size() > 0) {
			
			for(int i = 0; i < newList.size(); i++) {
				amount = newList.get(i).getBalance();
			}
			System.out.print("Enter deposit amount: ");

			String userInput = consoleReader.readLine();
			double deposit = Double.valueOf(userInput);
			amount += deposit;

			if(amount < 0 || deposit < 0) {
				System.out.println("Cannot be negative!");
				router.transfer("/deposit");
			}
			as.updateBalance(amount);
		}
		router.transfer("/dashboard");
	}
}
