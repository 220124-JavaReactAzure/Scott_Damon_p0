package com.revature.scottbank.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.scottbank.menus.RegisterMenu;
import com.revature.scottbank.menus.WelcomeMenu;
import com.revature.scottbank.services.CustomerService;


public class AppState {

	
		private static boolean isRunning;
		private final MenuRouter router;
		
		public AppState() {
			
			isRunning = true;
			router = new MenuRouter();
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			
			CustomerService customerService = new CustomerService();
			router.addMenu(new WelcomeMenu(consoleReader, router, customerService));
			router.addMenu(new RegisterMenu(consoleReader, router, customerService));
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