package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.util.MenuRouter;

public class DashboardMenu extends Menu {
	

	public DashboardMenu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super("Dashboard", "/dashboard", consoleReader, router);
	}
	
	public void render() throws Exception {
		
	}
}
