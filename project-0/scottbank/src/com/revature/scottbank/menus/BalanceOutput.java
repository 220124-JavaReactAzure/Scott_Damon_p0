package com.revature.scottbank.menus;
import com.revature.scottbank.models.Account;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.util.LinkedList;
import com.revature.scottbank.util.List;
import com.revature.scottbank.util.MenuRouter;

import java.io.BufferedReader;

public class BalanceOutput extends Menu {
	AccountService as;
	public BalanceOutput(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
	super("BalanceOutput", "/getbalance", consoleReader, router, accountService);
	as = accountService;
	}
	
		public void render() throws Exception {
		
			double amount = 0.0;
			String name = "";
			List<Account> newList = new LinkedList<>();
			newList = as.findAllBankAccounts();
			if (newList.size() > 0) {
				
				for(int i = 0; i < newList.size(); i++) {
					name = newList.get(i).getAccountName();
					amount = newList.get(i).getBalance();
				}
				System.out.println("Account name: " + name + "\nBalance: $" + amount);
			}
			router.transfer("/dashboard");

		}
			
}
