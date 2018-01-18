package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@Transactional
public class UserDaoImpl implements UserDao  {
	@Autowired
	private SessionFactory session;

	@Override
	public void insertUser(User user) {
		
		session.getCurrentSession().persist(user);
		
	}

	@Override
	public User getUserDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
