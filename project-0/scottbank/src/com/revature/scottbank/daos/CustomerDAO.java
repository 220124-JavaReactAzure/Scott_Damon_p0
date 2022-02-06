package com.revature.scottbank.daos;

import java.sql.SQLException;

import com.revature.scottbank.models.Customer;
import com.revature.scottbank.util.List;

public class CustomerDAO implements CrudDAO<Customer> {
	
	public Customer create(Customer newCustomer) {
		
		Customer customer = null;
		// TODO: establish a connection with the database.
/*		try {
			Connection conn = new Connection
		}catch(SQLException e) {
			e.printStackTrace();
		}
		*/
		return customer;

	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer updatedObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}