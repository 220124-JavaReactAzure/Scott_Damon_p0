package com.revature.scottbank.daos;

import com.revature.scottbank.util.List;

public interface CrudDAO<T> {

	// Create, Read, Update, Delete
	
	T create(T newObj);
	
	List<T> findAll();
	T findById(String id);
	
	boolean update(T updatedObj);
	
	boolean delete(String id);
}
