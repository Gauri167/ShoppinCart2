package com.shop.dao;

import java.util.List;

import com.shop.domain.Category;

public interface CategoryDAO {

	// to save new categories
	public boolean save(Category category);
	//to update categories
	public boolean update(Category category);
	//to delete categories
	public boolean delete(String id);
	//to get category
	public Category get(String id);
	//to get all categories
	public List<Category> categorylist();
	
}
