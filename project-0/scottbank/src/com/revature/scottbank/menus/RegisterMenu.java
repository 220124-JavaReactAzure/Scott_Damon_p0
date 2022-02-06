package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;

public class RegisterMenu extends Menu {

	public RegisterMenu() {

	}

	public RegisterMenu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super("Register", "/register", consoleReader, router);
	}
	
	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super(consoleReader, router, customerService);
	}

	@Override
	public void render() throws Exception {
			
	}
}


