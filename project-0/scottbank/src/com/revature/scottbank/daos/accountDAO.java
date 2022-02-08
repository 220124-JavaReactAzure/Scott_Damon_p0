package com.revature.scottbank.daos;

import com.revature.scottbank.models.Account;
import com.revature.scottbank.util.List;

public class accountDAO implements CrudDAO<Account> {
	
	public Account create(Account newAccount) {

		Account account = null;
		
		return account;
	}
// TODO: establish a connection with the database.
/*		try {
	Connection conn = new Connection
}catch(SQLException e) {
	e.printStackTrace();
}
*/


@Override
public List<Account> findAll() {
// TODO Auto-generated method stub
return null;
}

@Override
public Account findById(String id) {
// TODO Auto-generated method stub
return null;
}

@Override
public boolean update(Account updatedObj) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean delete(String id) {
// TODO Auto-generated method stub
return false;
}
}