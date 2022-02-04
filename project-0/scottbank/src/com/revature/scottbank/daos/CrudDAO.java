package com.revature.scottbank.daos;

public interface CrudDAO<T> {

	// Create, Read, Update, Delete
	
	T create(T newObj);
	
	List<T> findAll();
	T findById(String id);
	
	boolean update(T updatedObj);
	
	boolean delete(String id);
}
