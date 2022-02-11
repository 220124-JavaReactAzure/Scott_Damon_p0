package com.revature.scottbank.services;

import com.revature.scottbank.daos.AccountDAO;
import com.revature.scottbank.exceptions.InvalidRequestException;
import com.revature.scottbank.exceptions.ResourcePersistenceException;
import com.revature.scottbank.models.Account;
import com.revature.scottbank.util.List;

public class AccountService {

	private final AccountDAO accountDao;
	private final CustomerService customerService;
	
	public AccountService(AccountDAO accountDao, CustomerService customerService) {
		this.accountDao = accountDao;
		this.customerService = customerService;
	
}
	
	public void createAccount(Account newAccount) {	

			
			newAccount.setAccountOwner(customerService.getSessionCustomer());
			Account createdAccount = accountDao.create(newAccount);
			
			if(createdAccount == null) {
				throw new ResourcePersistenceException("The account could not be persisted");
			}
			
		}
	public List<Account> findAllBankAccounts(){
		return accountDao.findAll();
	}
	public boolean updateBalance(double updatedBalance) {
		return accountDao.update(updatedBalance);
	}


}

	
	

