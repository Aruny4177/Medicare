package com.niit.controller;
import com.niit.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;

@Controller
public class IndexController  {
	@Autowired
	UserDao userDao;
	@RequestMapping("/index")
	public ModelAndView Index()
	{
		ModelAndView obj = new ModelAndView("index");
		
		return obj;
	}
	@RequestMapping("/Arun")
	public ModelAndView About()
	{
		ModelAndView obj = new ModelAndView("about");
		return obj;
	}
	@RequestMapping("/resg")
	public ModelAndView Res(Model model)
	{
		ModelAndView obj = new ModelAndView("reg");
		model.addAttribute("user",new User());
		return obj;
	}
	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public String Inseruser(User user,Model model) {
    
	   userDao.insertUser(user);	
		return "redirect:/reg_sucess";

	}
	@RequestMapping("/Login")
	public ModelAndView Login()
	{
		ModelAndView obj = new ModelAndView("Login");
		return obj;
	}	
}
