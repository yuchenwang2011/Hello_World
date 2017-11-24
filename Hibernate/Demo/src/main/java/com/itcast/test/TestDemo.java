package com.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itcast.entity.User;
import com.itcast.hibernate.utils.HibernateUtils;

public class TestDemo {
	@Test
	public void testAdd() {
		//1. Read the hibernate.cfg.xml file	
		//2. Create a session factory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		//3. Open a session
		Session session = sessionFactory.openSession();
		
		//4. Start transaction
		Transaction transaction = session.beginTransaction();
		
		//5. Your own CRUD operations
		User user = new User();
		user.setUsername("Carly");
		user.setPassword("pwd");
		user.setAddress("US"); 
		session.save(user);
		
		//6. Commit transaction
		transaction.commit();
		
		//7. Close resources
		HibernateUtils.closeResource(session, sessionFactory);
	}
}
