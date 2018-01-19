package com.niit.dao;

import java.util.List;

import com.niit.Model.User;

public interface UserDao {

	public	List<User> getAll();
	public void addUser(User product);
	
	
}
