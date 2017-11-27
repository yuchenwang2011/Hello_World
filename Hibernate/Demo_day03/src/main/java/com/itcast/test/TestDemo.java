package com.itcast.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.itcast.entity.User;
import com.itcast.hibernate.utils.HibernateUtils;

public class TestDemo {
	@SuppressWarnings("deprecation")
	@Test
	public void testSQLQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
//			@SuppressWarnings("deprecation")
//			SQLQuery sqlQuery = session.createSQLQuery("select * from User");
//			@SuppressWarnings("deprecation")
//			List<Object[]> list = sqlQuery.list();
//			for (int i = 0; i < list.size(); i++){
//				System.out.println(Arrays.toString(list.get(i)));
//			}
			
			@SuppressWarnings({ "deprecation", "rawtypes" })
			SQLQuery sqlQuery = session.createSQLQuery("select * from User");
			sqlQuery.addEntity(User.class);
			List<User> list = sqlQuery.list();
			for(User user : list) {
				System.out.println(user);
			}
			
			tx.commit();
		} catch (Exception e	) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testCriteria() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(User.class);
			List<User> list = criteria.list();
			for(User user : list) {
				System.out.println(list);
			}
			
			tx.commit();
		} catch (Exception e	) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from User");
			@SuppressWarnings("unchecked")
			List<User> list = query.getResultList();
			for(User user : list) {
				System.out.println(user);
			}
			
			tx.commit();
		} catch (Exception e	) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testTransaction() {
		Session session = null;
		Transaction tx = null;
		try {
			//get a session bound to current context
			session = HibernateUtils.getSessionObject();
			tx = session.beginTransaction();
			
			User user = new User();
			user.setUsername("David");
			user.setPassword("1314");
			user.setAddress("Austrilia");
			session.save(user);
			
			//int i = 10 / 0;
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			//in a web project, you don't really need to close it
			//because you only create factory once in the static block
			session.close();
		}
	}
	
	
	@Test
	public void testDelete() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
//		User user = session.get(User.class, 1);
//		session.delete(user);
		
		//Another method
		User user2 = new User();
		user2.setUid(2);
		session.delete(user2);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	@Test
	public void testUpdate() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 2);
		user.setUsername("peter");
		session.update(user);
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	@Test
	public void testSelect() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1);
		System.out.println("=========");
		System.out.println(user.toString());
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
