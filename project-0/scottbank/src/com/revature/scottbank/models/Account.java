package com.revature.scottbank.models;

import java.io.Serializable;

public class Account implements Serializable {

	// TODO: Attributes go here. checking, savings, checkingBalance, SavingsBalance
	private int checkingID;
	private int SavingsID;
	private double checkingBalance;
	private double savingsBalance;
	
	
	public Account() {
		super();
	}
}