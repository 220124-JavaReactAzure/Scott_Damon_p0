package com.revature.scottbank.models;

public class Account {

	
	private Customer accountOwner;
	private String accountId;
	private double balance;
	private String accountName;
	
	
	
	public Account() {
		super();
	}
	
	public Account(String accountId, String accountName, double balance, Customer accountOwner) {
		this.accountName = accountName;
		this.balance = balance;
		this.accountId = accountId;
		this.accountOwner = accountOwner;

}
	public Account (String accountName, double balance) {
		this.accountName = accountName;
		this.balance = balance;
	}
	
	public Customer getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Customer accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


}