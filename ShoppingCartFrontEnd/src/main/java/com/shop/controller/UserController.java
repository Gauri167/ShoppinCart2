package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.UserDAO;
import com.shop.domain.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;

	@RequestMapping(name="/validate",method=RequestMethod.POST)
	public ModelAndView validate(@RequestParam("uname") String username,@RequestParam("pswd") String password)
	{
		ModelAndView mv=new ModelAndView("home");
		user=userDAO.validate(username, password);
		if(user==null)
			 mv.addObject("errorMessage","Invalid");
		else mv.addObject("welcomeMessage",user.getName());
		return mv;
		
	}
}
