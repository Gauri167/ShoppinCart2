package com.shop.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.dao.SupplierDAO;
import com.shop.domain.Supplier;

public class SupplierDAOTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Supplier supplier;
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.shop");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		supplier=(Supplier)context.getBean("supplier");
	}
	
	@Test
	public void saveSupplierTestCase() {
		
		supplier.setId("SUP-007");
		supplier.setName("BigC");
		supplier.setAddress("Mumbai");
		
		boolean status=supplierDAO.save(supplier);
		assertTrue("saveSupplierTestCase",status);
	}
	
	@Test
	public  void updateSupplierTestCase() {
		
		supplier.setId("SUP-001");
		supplier.setName("BigD");
		
		boolean status=supplierDAO.update(supplier);
		assertEquals("updateSupplierTestCase",true,status);
	}
	
	@Test
	public void deleteSupplierSuccessTestCase() {
		
		boolean status=supplierDAO.delete("SUP-006");
		assertEquals("deleteSupplierSuccessTest",true,status);
	}
	
	@Test
	public void deleteSupplierFailureTestCase() {
		boolean status=supplierDAO.delete("SUP-101");
		assertEquals("deleteSupplierFailureTestCase",false,status);
	}
	
	@Test
	public void getSupplierSuccessTestCase() {
		
		supplier=supplierDAO.get("SUP-003");
		assertNotNull("getSupplierSuccessTestCase",supplier);
	}
	
	@Test
	public void getSupplierFailureTestCase() {
		
		supplier=supplierDAO.get("SUP-101");
		assertNull("getSupplierFailureTestCase",supplier);
	}
	
	@Test
	public void getAllSuppliersTestCase() {
		List<Supplier> suppliers=supplierDAO.supplierlist();
		assertNotNull("getAllSuppliersTestCase",suppliers);
	}
}
