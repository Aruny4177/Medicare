package com.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping("/index")
	public ModelAndView Index()
	{
		ModelAndView obj=new ModelAndView("index");
		return obj;
	}
	
	@RequestMapping("/about")
	public ModelAndView About()
	{
		ModelAndView obj=new ModelAndView("about");
		return obj;
	}
	
	@RequestMapping("/contact")
	public ModelAndView Contact()
	{
		ModelAndView obj=new ModelAndView("contact");
		return obj;
	}
	
	@RequestMapping("/reg")
	public ModelAndView Reg()
	{
		ModelAndView obj =new ModelAndView("reg");
		return obj;
	}
	
	@RequestMapping("/Login")
	public ModelAndView login()
	{
		ModelAndView obj=new ModelAndView("Login");
		return obj;
	}
}
