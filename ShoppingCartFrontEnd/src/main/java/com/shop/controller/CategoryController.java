package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

public class CategoryController {
	
	//we need to call CategoryDAO methods
	//get,save,update,delete,list
	
	//1.inject the CategoryDAO
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	//http://localhost8080/shoppingcart/category/get/cate_001
	@RequestMapping(name="/category/get/{id}",method=RequestMethod.GET)
	public ModelAndView getCategory(@RequestParam("id") String id) 
	{
		//based on id,fetch the details from categoryDAO
		category=categoryDAO.get(id);
		
		//navigate to home page
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("category",category);
		return mv;
		
	}
	
	/*@RequestMapping(name="/category/save/",method=RequestMethod.POST)
	public ModelAndView saveCategory(@RequestParam("id") String id,
			                         @RequestParam("") String name,
			                         @RequestParam("") String description)*/
	//instead of writing each value one by one
	//use request body
	
	public ModelAndView saveCategory(@RequestBody Category category)
	{
		
		//navigate to home page
				ModelAndView mv=new ModelAndView("home");
				//call save method of categoryDAO
				if(categoryDAO.save(category)==true)
				{
					//add success message
					mv.addObject("successMessage","Category saved successfully");
				}
				else
				{
					//add failure message
					mv.addObject("errorMessage","Could not save the category");
				}
				return mv;
	}
	
	@RequestMapping(name="/category/update/",method=RequestMethod.PUT)
	public ModelAndView updateCategory(@RequestBody Category category)
	{
		
		//navigate to home page
				ModelAndView mv=new ModelAndView("home");
				//call save method of categoryDAO
				if(categoryDAO.save(category)==true)
				{
					//add success message
					mv.addObject("successMessage","Category updated successfully");
				}
				else
				{
					//add failure message
					mv.addObject("errorMessage","Could not update the category");
				}
				return mv;
	}
	
	@RequestMapping(name="/category/get/{id}",method=RequestMethod.DELETE)
	public ModelAndView deleteCategory(@RequestParam("id") String id) 
	{
		//navigate to home page
				ModelAndView mv=new ModelAndView("home");
		//based on id,fetch the details from categoryDAO
		if(categoryDAO.delete(id)==true)
		{
			//add success message
			mv.addObject("successMessage","Category deleted successfully");
		}
		else
		{
			//add failure message
			mv.addObject("errorMessage","Could not delete the category");
		}
		return mv;
		
	}
	
	@RequestMapping(name="/categories",method=RequestMethod.GET)
	public ModelAndView getAllCategories()
	{
		ModelAndView mv=new ModelAndView("home");
		List<Category> categories=categoryDAO.categorylist();
		mv.addObject("categories",categories);
		return mv;
	}
	
}
		
	