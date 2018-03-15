package com.shop.daoimpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dao.UserDAO;
import com.shop.domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
    @Autowired
	private SessionFactory sessionFactory;
    
    @Autowired
    private User user;
    
	public boolean save(User user) {
		
		try {
			user.setRole('C');
			user.setRegisterDate(new Date());
		sessionFactory.getCurrentSession().save(user);
			return true;
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
    
	public boolean update(User user) {
		try {
			
	     sessionFactory.getCurrentSession().update(user);
	     return true;
	    } 
	catch (HibernateException e) {
		e.printStackTrace();
		return false;}
	}

	public boolean delete(String emailId) {
    	try {
		user=get(emailId);
		if(user==null)
			{return false;}
			sessionFactory.getCurrentSession().delete(user);
			return true;
    	}
	 catch (HibernateException e) {
		e.printStackTrace();
		return false;
	  }
	 }

	public User get(String emailId) {
		try {
		return sessionFactory.getCurrentSession().get(User.class,emailId);}
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		  }
	}

	@SuppressWarnings("deprecation")
	public User validate(String emailId, String password) {
	 user= (User) sessionFactory.getCurrentSession().createCriteria(User.class).
				add(Restrictions.eq("emailId",emailId)).
				add(Restrictions.eq("password",password)).uniqueResult();
	 return user;
	}
	
	
	@SuppressWarnings("unchecked")
	
	public List<User> userlist() {
		Session session=sessionFactory.openSession();
		return session.createQuery("from User").list();
	}

}
