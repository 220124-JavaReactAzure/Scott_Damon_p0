package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;

public class accountSelect extends Menu {
		

	public accountSelect(BufferedReader consoleReader, MenuRouter router,  AccountService accountService) {
		super("accountSelect", "/accountSelect", consoleReader, router, accountService);
	}
		
	public void render() throws Exception {
		// TODO: Implement account selection menu.
	}
}