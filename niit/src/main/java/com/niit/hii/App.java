package com.niit.hii;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Model.User;
import com.niit.config.hibernateConfig;
import com.niit.dao.UserDao;
import com.niit.daoimpl.UserDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	 
	public static void main( String[] args )
    {
	
		 AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext();
	     ctxt.scan("com.niit");
	     ctxt.refresh();
	    UserDao dao= ctxt.getBean(UserDao.class);
	    User user = new User();
	  
	    user.setName("arun");
	    user.setPhone("9458439953");
	    user.setPassword("niit@12");
	    user.setAddress("lko");
	    user.setEmail("p@gmail.com");
	    user.setCountry("india");
	    dao.addUser(user);
	//for print System.out.println   (user.toString());
	    //List<User>list =dao.getAll();
	    //System.out.println(list);
	    ctxt.close();
       
    }
}
