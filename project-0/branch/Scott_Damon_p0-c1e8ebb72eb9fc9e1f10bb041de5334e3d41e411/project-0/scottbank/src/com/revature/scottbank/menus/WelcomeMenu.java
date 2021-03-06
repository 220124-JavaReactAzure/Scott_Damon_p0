package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;
import static com.revature.scottbank.util.AppState.shutdown;

public class WelcomeMenu extends Menu {
	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Welcome", "/welcome", consoleReader, router, customerService);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void render() throws Exception {
		
		System.out.print("Welcome to Scott Bank!\n" + "1) Login\n" + "2) Register\n" + "3) Exits\n" + ">> ");
		
		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
		default:
			System.out.println("Invalid input");
			router.transfer("/welcome");
			break;
		}
		
	}

}
