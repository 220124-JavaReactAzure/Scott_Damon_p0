package com.revature.scottbank.daos;

import java.sql.Connection;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.scottbank.models.Account;
import com.revature.scottbank.models.Customer;
import com.revature.scottbank.services.AccountService;
import com.revature.scottbank.util.LinkedList;
import com.revature.scottbank.util.List;
import com.revature.scottbank.util.datasource.ConnectionFactory;


public class AccountDAO implements CrudDAO<Account> {
	
	public List<Account> findByAccountOwner(String id){
		return null;
	}


	public Account create(Account newAccount) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			 newAccount.setAccountId(UUID.randomUUID().toString()); 
			
			String sql = "insert into accountdetails (account_id,"
					+ " customer_account_id, balance, account_name) values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newAccount.getAccountId());
			ps.setString(2,	newAccount.getAccountOwner().getCustomerId());
			ps.setDouble(3, newAccount.getBalance());
			ps.setString(4, newAccount.getAccountName());
			
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
		String sql = "select * from accountdetails";
		Statement s = conn.createStatement();
		

		ResultSet resultSet = s.executeQuery(sql);

		while (resultSet.next()) {
			Account account = new Account();
			account.setAccountId(resultSet.getString("account_id"));
//			account.setAccountOwner(resultSet).getAccountOwner().getCustomerId("customer_account_id");
			account.setAccountName(resultSet.getString("account_name"));
			account.setBalance(resultSet.getDouble("balance"));


			accountList.add(account);
		}

		return accountList;

	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	return null;
}

public boolean update(double updateBalance) {
	try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

		
		

		String sql = "update accountdetails set balance = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql); 
		ps.setDouble(1, updateBalance);
		ps.executeUpdate(); return true;
	}catch (SQLException e) {
		e.printStackTrace();
	}
return false;
}

@Override
public Account findById(String id) {
// TODO Auto-generated method stub
return null;
}

@Override
public boolean update(Account updatedObj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Account acc = updatedObj;
			double curBal = acc.getBalance();
			
			

			String sql = "update accountdetails set balance = ? where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
}


@Override
public boolean delete(String id) {
// TODO Auto-generated method stub
return false;
}
}
