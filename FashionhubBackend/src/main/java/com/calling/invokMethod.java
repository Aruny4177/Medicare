package com.calling;

import com.Dao.UserDao;
import com.Daoimpl.UserdDaoImpl;
import com.Model.User;

public class invokMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	User obj=new User();
	obj.setEmail("niitarun@gmail.com");
	UserdDaoImpl ob = new UserdDaoImpl();
	ob.show(obj.getEmail());
		
		
		

	}

}
