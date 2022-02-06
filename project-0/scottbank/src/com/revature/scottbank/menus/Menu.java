package com.revature.scottbank.menus;

import java.io.BufferedReader;

import com.revature.scottbank.util.MenuRouter;

public abstract class Menu {

	protected String name;
	protected String route;
	protected BufferedReader consoleReader;
	protected MenuRouter router;
	
	public Menu() {
	
	}
	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
	}
	
	public Menu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		this.consoleReader = consoleReader;
		this.router = router;
		this.customerService = customerService;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRoute() {
		return route;
	}
	
	public abstract void render() throws Exception;
}
