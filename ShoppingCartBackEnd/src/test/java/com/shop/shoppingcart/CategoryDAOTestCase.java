package com.shop.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

public class CategoryDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Category category;
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");
	}
	
	@Test
	public void saveCategoryTestCase() {
		category.setId("Clothes-003");
		category.setName("Womens");
		category.setDescription("Womens Category");
		boolean status=categoryDAO.save(category);
		assertTrue("saveCategoryTestCase",status);
	}
	
	@Test
	public void updateCategoryTestCase() {
		category.setId("Mob-001");
		category.setName("SmartPhones");
		boolean status=categoryDAO.update(category);
		assertEquals("updateCategoryTestCase",true,status);
	}
	
	@Test
	public void deleteCategorySuccessTestCase() {
		
		boolean status=categoryDAO.delete("Clothes-002");
		assertEquals("deleteCategorySuccessTest",true,status);
	}
	
	@Test
	public void deleteCategoryFailureTestCase() {
		boolean status=categoryDAO.delete("Electronics-001");
		assertEquals("deleteCategoryFailureTestCase",false,status);
	}
	
	@Test
	public void getCategorySuccessTestCase() {
		
		category=categoryDAO.get("Kids-001");
		assertNotNull("getCategorySuccessTestCase",category);
	}
	
	@Test
	public void getCategoryFailureTestCase() {
		
		category=categoryDAO.get("Sports-001");
		assertNull("getCategoryFailureTestCase",category);
	}
	
	@Test
	public void getAllCategoriesTestCase() {
		
		List<Category> categories=categoryDAO.categorylist();
		assertNotNull("getAllCategoriesTestCase",categories);
	}
}
