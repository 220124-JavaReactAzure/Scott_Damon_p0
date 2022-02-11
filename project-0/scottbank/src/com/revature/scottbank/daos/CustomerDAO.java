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

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from customer where username = ? and pass = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("pass"));

				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Customer findByUsername(String username) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select from customer where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("pass"));

				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Customer findByEmail(String email) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from customer where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("pass"));

				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Customer create(Customer newCustomer) {

		// Try-with-resources because the connection is AutoClosable(an interface)
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// Set the PK value in java to be added to my data
			// Unique 128-bit string
			newCustomer.setCustomerId(UUID.randomUUID().toString());

			// The ? are to be added later using the PreparedStatement objects
			// .set(DataType)
			String sql = "insert into customer (customer_id, first_name, last_name, email, username, pass) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			// Adjusting the PreparedStatement to appropriate fill in the ? and execute the
			// SQL statement
			ps.setString(1, newCustomer.getCustomerId());
			ps.setString(2, newCustomer.getFirstName());
			ps.setString(3, newCustomer.getLastName());
			ps.setString(4, newCustomer.getEmail());
			ps.setString(5, newCustomer.getUsername());
			ps.setString(6, newCustomer.getPassword());

			// Use executeUpdate to perform DML (Insert, Update, Delete)
			int rowsInserted = ps.executeUpdate();

			// checking to see if the update occurred.
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
				customer.setPassword(resultSet.getString("pass"));

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