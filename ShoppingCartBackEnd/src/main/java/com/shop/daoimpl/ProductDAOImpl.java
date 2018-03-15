package com.shop.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.ProductDAO;
import com.shop.domain.Category;
import com.shop.domain.Product;
import com.shop.domain.Supplier;
@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Product product;
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			if(product.getId()==null)
				{return false;}
			sessionFactory.getCurrentSession().update(product);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(String id) {
		try {
			product=get(id);
			if(product==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Product get(String id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Product.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> productlist() {
		Session session=sessionFactory.openSession();
		return session.createQuery("from Product").list();
	}

	public Product getCategory(Category category) {
		
		return null;
	}

	public Product getSupplier(Supplier supplier) {
		
		return null;
	}

	

}
