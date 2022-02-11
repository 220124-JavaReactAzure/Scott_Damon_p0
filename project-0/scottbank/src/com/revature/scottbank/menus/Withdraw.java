package com.revature.scottbank.menus;

import com.revature.scottbank.models.Account;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.util.LinkedList;
import com.revature.scottbank.util.List;
import com.revature.scottbank.util.MenuRouter;

import java.io.BufferedReader;

public class Withdraw extends Menu {
	AccountService as;

	public Withdraw(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {

		super("Withdraw", "/withdraw", consoleReader, router, accountService);
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
			System.out.print("Enter withdrawal amount: ");

			String userInput = consoleReader.readLine();
			double withdraw = Double.valueOf(userInput);
			amount -= withdraw;

			if(amount < 0) {
				System.out.println("Insufficient funds!");
				router.transfer("/withdraw");
			}
			if(withdraw < 0) {
				System.out.println("Cannot withdraw a negative amount.");
				router.transfer("/withdraw");
			}
			as.updateBalance(amount);
		}
		router.transfer("/dashboard");
	}
}
