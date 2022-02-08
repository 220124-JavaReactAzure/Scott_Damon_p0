package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;

public class DashboardMenu extends Menu {
	

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Dashboard", "/dashboard", consoleReader, router, customerService);
	}
	
	public void render() throws Exception {
		
		System.out.println("Welcome!\n 1) Withdraw\n 2) Deposit\n 3) Check Balance\n 4) Reset password\n >>");
		
		String userSelection = consoleReader.readLine();
		
		switch(userSelection) {
		
		case("1"):
			router.transfer("/accountType");
			break;
		
		
		case("2"): 
			router.transfer("/accountType");
			break;
			
		case("3"):
			router.transfer("/accountType");
			break;
			
		case("4"):
			router.transfer("/passReset");
			break;
			
		default:
			System.out.println("Invalid input");
			router.transfer("/dashboard");
			break;
		}
	}
}
