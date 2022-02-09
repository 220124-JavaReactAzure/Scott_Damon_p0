package com.revature.scottbank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.revature.scottbank.models.Customer;
import com.revature.scottbank.util.LinkedList;
import com.revature.scottbank.util.List;
import com.revature.scottbank.util.datasource.ConnectionFactory;


public class CustomerDAO implements CrudDAO<Customer> {
	
	public Customer findByUsernameAndPassword(String username, String password) {
	
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from customer where username = ? and passvord = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("passvord"));
				
				return customer;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Customer findByUsername(String username){
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select from customer where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("passvord"));
				
				return customer;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Customer findByEmail(String email){
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from customer where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("passvord"));
				
				return customer;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public Customer create(Customer newCustomer) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			newCustomer.setCustomerId(UUID.randomUUID().toString());

			String sql = "insert into customer (customer_id, first_name, last_name, email, username, passvord) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, newCustomer.getCustomerId());
			ps.setString(2, newCustomer.getFirstName());
			ps.setString(3, newCustomer.getLastName());
			ps.setString(4, newCustomer.getEmail());
			ps.setString(5, newCustomer.getUsername());
			ps.setString(6, newCustomer.getPassword());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted != 0) {
				return newCustomer;
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return null;

	}
	
	@Override
	public List<Customer> findAll() {

		List<Customer> customerList = new LinkedList<>();

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from customer";
			Statement s = conn.createStatement();

			ResultSet resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setEmail(resultSet.getString("email"));
				customer.setUsername(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("passvord"));

				customerList.add(customer);
			}

			return customerList;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Customer updatedObj) {
		
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}