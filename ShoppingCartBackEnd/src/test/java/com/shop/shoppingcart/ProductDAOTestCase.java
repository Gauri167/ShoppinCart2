package com.shop.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.CategoryDAO;
import com.shop.dao.ProductDAO;
import com.shop.domain.Category;
import com.shop.domain.Product;

public class ProductDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Product product;
	@Autowired
	private static ProductDAO productDAO;
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		product=(Product)context.getBean("product");
	}
	
	@Test
	public void saveProductTestCase() {
		product.setId("Oppo-004");
		product.setName("Oppo");
		product.setDescription("Oppo Product");
		product.setCategoryId("Mob-001");
		product.setSupplierId("SUP-001");
		
		boolean status=productDAO.save(product);
		
		assertTrue("saveProductTestCase",status);
	}
	
	@Test
	public void updateProductTestCase() {
		product.setId("Lenovo-001");
		product.setName("Lenovo A1");
		boolean status=productDAO.update(product);
		assertEquals("updateProductTestCase",true,status);
	}
	
	@Test
	public void deleteProductSuccessTestCase() {
		
		boolean status=productDAO.delete("Opp-004");
		assertEquals("deleteProductSuccessTest",true,status);
	}
	
	@Test
	public void deleteProductFailureTestCase() {
		boolean status=productDAO.delete("Electronics-001");
		assertEquals("deleteProductFailureTestCase",false,status);
	}
	
	@Test
	public void getProductSuccessTestCase() {
		
		product=productDAO.get("Lenovo-001");
		assertNotNull("getProductSuccessTestCase",product);
	}
	
	@Test
	public void getProductFailureTestCase() {
		
		product=productDAO.get("Sports-001");
		assertNull("getProductFailureTestCase",product);
	}
	
	@Test
	public void getAllProductsTestCase() {
		List<Product> products=productDAO.productlist();
		assertNotNull("getAllProductsTestCase",products);
	}
	
	// slt missed 
	// to be completed later
	//@Test
	public void getAllCategoriesTestCase() {
		List<Category> categories=categoryDAO.categorylist();
		assertNotNull("getAllCategories",categories);
	}
}
