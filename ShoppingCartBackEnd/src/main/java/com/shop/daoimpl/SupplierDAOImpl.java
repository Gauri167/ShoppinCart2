package com.shop.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.SupplierDAO;
import com.shop.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Supplier supplier;
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {
			if(supplier.getId()==null)
				{return false;}
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(String id) {
		try {
			supplier=get(id);
			if(supplier==null)
			{  return false;  }
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Supplier get(String id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Supplier.class,id);
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> supplierlist() {
		
		Session session=sessionFactory.openSession();
		return session.createQuery("from Supplier").list();
	}

	
	

}
