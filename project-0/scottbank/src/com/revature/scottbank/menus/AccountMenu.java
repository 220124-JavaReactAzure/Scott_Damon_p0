
package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.util.MenuRouter;
import com.revature.scottbank.exceptions.InvalidRequestException;
import com.revature.scottbank.models.Account;
import com.revature.scottbank.models.Customer;

public class AccountMenu extends Menu{
	
	public AccountMenu() {
		
	}
	
	public AccountMenu(BufferedReader consoleReader, MenuRouter router, AccountService customerService) {
		super("Accountmenu", "/accountmenu", consoleReader, router, customerService);
	}
		
	@Override
	public void render() throws Exception {
		
		System.out.print("You have chosen to create an account\n 1) Checking\n 2) Savings\n 3) Back \n >>");
	
		String userSelection = consoleReader.readLine();
		
		switch(userSelection) {
		
		case"1":
			router.transfer("/createchecking");
			break;
			
		case"2":
			router.transfer("/createsavings");
			break;
			
		case"3":
			router.transfer("/dashboard");
			break;
			
		
		default:
			System.out.println("Invalid input, try again\n\n\n");
			router.transfer("/accountmenu");
			break;
			
		}
			
	}

}
