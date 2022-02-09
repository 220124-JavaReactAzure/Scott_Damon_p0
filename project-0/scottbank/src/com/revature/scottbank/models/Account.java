package com.revature.scottbank.models;

public class Account {

	
	// TODO: Attributes go here. checking, savings, checkingBalance, SavingsBalance

	private Customer accountOwner;
	private String accountId;
	private double checkingBalance;
	private double savingsBalance;
	
	
	
	public Account() {
		super();
	}
	
	public Account(String accountId, double checkingtBalance, double savingsBalance, Customer accountOwner) {
		this.checkingBalance = checkingtBalance;
		this.savingsBalance = savingsBalance;
		this.accountId = accountId;
	


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

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
}