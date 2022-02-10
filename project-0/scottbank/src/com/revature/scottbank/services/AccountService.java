package com.revature.scottbank.services;

import com.revature.scottbank.daos.AccountDAO;
import com.revature.scottbank.exceptions.InvalidRequestException;
import com.revature.scottbank.exceptions.ResourcePersistenceException;
import com.revature.scottbank.models.Account;

public class AccountService {

	private final AccountDAO accountDao;
	private final CustomerService customerService;
	
	public AccountService(AccountDAO accountDao, CustomerService customerService) {
		this.accountDao = accountDao;
		this.customerService = customerService;
	
}
	
	public Account createAccount(Account newAccount) {
		
		
		newAccount.setAccountOwner(customerService.getSessionCustomer());
		Account createdAccount = accountDao.create(newAccount);
		
		if(createdAccount == null) {
			throw new ResourcePersistenceException("The account was unable to be persisted");
		}
		return newAccount;
	}
	
	private boolean isAccountValid(Account newAccount) {
		
		if(newAccount == null) return false;
		if(newAccount.getAccountId() == null) return false;
		if(newAccount.getAccountOwner() == null) return false;
		return newAccount.getBalance() == 0;
		
	}
	
}

	
	

