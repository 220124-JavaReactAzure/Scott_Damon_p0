package com.revature.scottbank.util;

import java.awt.Menu;
import java.util.LinkedList;

public class MenuRouter {
	private final LinkedList<Menu> menus;
	
	public MenuRouter() {
		menus = new LinkedList<>();
	}
	
	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	
	public void transfer(String route) throws Exception {
		for(int i = 0; i < menus.size(); i++) {
			Menu currentMenu = menus.get(i);
			if(currentMenu.getRoute().equals(route)) {
				currentMenu.render();
			}
		}
	}
}