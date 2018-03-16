package com.shop.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(name="/saveUser",method=RequestMethod.GET)
	public ModelAndView saveUser(@PathVariable("uname")String username,@PathVariable("pswd")String password,@PathVariable("rpswd")String rpassword,@PathVariable("name")String name,@PathVariable("mobile")String mobile)
	{
		
		ModelAndView mv=new ModelAndView("home");
		if(rpassword.equals(password))
		{user.setEmailId(username);
		user.setMobile(mobile);
		user.setName(name);
		user.setPassword(password);
		user.setRegisterDate(new Date());
		user.setRole('C');
		if(userDAO.save(user)==true)
		{
			//add success message
			mv.addObject("welcomeMessage","Welcome "+user.getName()+" Enjoy Shopping");
		}
		else
		{
			//add failure message
			mv.addObject("errorMessage","Could not create Account...Please try again");
		}
		}
		else mv.addObject("errorMessage","Password Mismatch");
		return mv;
	}
}
