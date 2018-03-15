package com.shop.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.CategoryDAO;
import com.shop.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Category category;
	
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		try {
			if(category.getId()==null)
				{return false;}
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(String id) {
		try {
			category=get(id);
			if(category==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Category get(String id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Category.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> categorylist() {
		Session session=sessionFactory.openSession();
		return session.createQuery("from Category").list();
	}

	

}
