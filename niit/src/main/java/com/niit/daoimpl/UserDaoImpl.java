package com.niit.daoimpl;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.User;
import com.niit.dao.UserDao;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);
	}

	
}
