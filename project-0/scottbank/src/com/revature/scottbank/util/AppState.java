package com.revature.scottbank.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.scottbank.daos.CustomerDAO;
import com.revature.scottbank.daos.AccountDAO;
import com.revature.scottbank.menus.AccountMenu;
// import com.revature.scottbank.menus.AccountMenu;
import com.revature.scottbank.menus.DashboardMenu;
import com.revature.scottbank.menus.LoginMenu;
import com.revature.scottbank.menus.RegisterMenu;
import com.revature.scottbank.menus.WelcomeMenu;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.services.CustomerService;
import com.revature.scottbank.util.Logger;

public class AppState {

		private final Logger logger;
		private static boolean isRunning;
		private final MenuRouter router;
		
		public AppState() {
			
			logger = Logger.getLogger(true);
			logger.log("Initializing application...");
			 
			isRunning = true;
			router = new MenuRouter();
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			
			CustomerDAO customerDao = new CustomerDAO();
			CustomerService customerService = new CustomerService(customerDao);
			router.addMenu(new WelcomeMenu(consoleReader, router, customerService));
			router.addMenu(new RegisterMenu(consoleReader, router, customerService));
			router.addMenu(new LoginMenu(consoleReader, router, customerService));		
			router.addMenu(new DashboardMenu(consoleReader, router, customerService));
			
			
			AccountDAO accountDao = new AccountDAO();
			AccountService accountService = new AccountService(accountDao, customerService);
			router.addMenu(new AccountMenu(consoleReader, router, accountService));
		
			
			logger.log("Application is initialized! YAR!");
		}

public void startUp() {
	try {
		while(isRunning) {
		router.transfer("/welcome");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void shutdown() {
	isRunning = false;
	}
}