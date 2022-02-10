package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.models.Account;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.MenuRouter;

public class DashboardMenu extends Menu {
	

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Dashboard", "/dashboard", consoleReader, router, customerService);
	}
	
	public void render() throws Exception {
		
		System.out.print("Welcome!\n 1) Create Account\n 2) Withdraw\n 3) Deposit\n 4) Check Balance\n 5) Logout\n >>");
		
		String userSelection = consoleReader.readLine();
		
		switch(userSelection) {
		
		case"1":
			router.transfer("/accountmenu");
			break;
		
		case"2": 
			router.transfer("/withdraw");
			break;
			
		case"3":
			router.transfer("/deposit");
			break;
		
		case"4":
			router.transfer("/getbalance");
			break;
			
		case"5":
			router.transfer("/welcome");
			break;
			
		default:
			System.out.println("Invalid input");
			router.transfer("/dashboard");
			break;
		}
	}
}
