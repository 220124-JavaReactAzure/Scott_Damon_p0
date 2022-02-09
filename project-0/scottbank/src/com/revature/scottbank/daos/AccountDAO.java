package com.revature.scottbank.daos;

import java.sql.Connection;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.scottbank.models.Account;
import com.revature.scottbank.models.Customer;
import com.revature.scottbank.util.LinkedList;
import com.revature.scottbank.util.List;
import com.revature.scottbank.util.datasource.ConnectionFactory;


public class AccountDAO implements CrudDAO<Account> {
	
	public List<Account> findByAccountOwner(String id){
		return null;
	}


	@Override
	public Account create(Account newAccount) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			newAccount.setAccountId(UUID.randomUUID().toString());
			
			String sql = "insert into accountdetails (account_id,"
					+ " customer_account_id, checking_balance, savings_balance,"
					+ " customer_account_id) values (default, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newAccount.getAccountId());
			ps.setString(2,	newAccount.getAccountOwner().getCustomerId());
			ps.setDouble(4, newAccount.getCheckingBalance());
			ps.setDouble(5, newAccount.getSavingsBalance());
			
			
			int rowsInserted = ps.executeUpdate();
			
			if (rowsInserted != 0)
				return newAccount;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
@Override
public List<Account> findAll() {

	List<Account> accountList = new LinkedList<>();

	try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
		String sql = "select * from customer";
		Statement s = conn.createStatement();

		ResultSet resultSet = s.executeQuery(sql);

		while (resultSet.next()) {
			Account account = new Account();
			account.setAccountId(resultSet.getString("account_id"));
//			account.setAccountOwner(resultSet.get("customer_account_id"));
			account.setCheckingBalance(resultSet.getDouble("checking_balance"));
			account.setSavingsBalance(resultSet.getDouble("savings_balance"));


			accountList.add(account);
		}

		return accountList;

	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

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