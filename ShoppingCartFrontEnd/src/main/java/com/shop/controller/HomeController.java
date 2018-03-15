package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("home");
		//we need to fetch all the categories and attach to mv
		// for this first Autowire categoryDAO and Category
		
		List<Category> categories=categoryDAO.categorylist();
		mv.addObject("categories",categories);
		mv.addObject("welcomeMessage","Welcome");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedLogin",true);
		return mv;
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUp()
	{
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("UserClickedSignUp",true);
		return mv;
	}
}
