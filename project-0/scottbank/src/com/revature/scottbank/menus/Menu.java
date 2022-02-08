package com.revature.scottbank.menus;

import java.io.BufferedReader;



import com.revature.scottbank.util.MenuRouter;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.services.CustomerService;


public abstract class Menu {

	protected String name;
	protected String route;
	protected BufferedReader consoleReader;
	protected MenuRouter router;
	protected CustomerService customerService;
	protected AccountService accountService;
	
	public Menu() {
	
	}
	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
		this.customerService = customerService;
	}
	
	public Menu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		this.consoleReader = consoleReader;
		this.router = router;
		this.customerService = customerService;
	}
	
	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
		this.accountService = accountService;
		}
	
	public String getName() {
		return name;
	}
	
	public String getRoute() {
		return route;
	}
	
	public abstract void render() throws Exception;
}
