package com.Daoimpl;

import java.util.List;

import com.Dao.UserDao;
import com.Model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserdDaoImpl implements UserDao {

	public void show(String email) {
		// TODO Auto-generated method stub
		System.out.println(email);
		
	}

}
