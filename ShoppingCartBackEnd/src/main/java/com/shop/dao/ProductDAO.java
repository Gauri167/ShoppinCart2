package com.shop.dao;

import java.util.List;

import com.shop.domain.Category;
import com.shop.domain.Product;
import com.shop.domain.Supplier;

public interface ProductDAO {

	// to save a new product
	public boolean save(Product product);
	//to update a product
	public boolean update(Product product);
	// to delete a product
	public boolean delete(String id);
	// to get a product
	public Product get(String id);
	// to get all products
	public List<Product> productlist();
	// to get category of Product
	public Product getCategory(Category category);
	//to get Supplier of product
	public Product getSupplier(Supplier supplier);
}
