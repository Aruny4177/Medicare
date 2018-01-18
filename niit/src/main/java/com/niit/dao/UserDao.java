package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {

	public void insertUser(User user);
	public User getUserDetails(String email);
	

   public User getUById(int customerId);

   public List<User> getAllCustomers();

   User getCustomerByUsername(String username);
}
