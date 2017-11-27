package com.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itcast.hibernate.utils.HibernateUtils;
import com.itcast.many2many.entity.Role;
import com.itcast.many2many.entity.User;

public class HibernateManytoMany {
	@Test
	public void testDeleteRole() {
		//manipulate the third table
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			
			user.getRoleSet().remove(role);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testAddRole() {
		//manipulate the third table
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 3);
			
			user.getRoleSet().add(role);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testDeleteUser() {
		//Delete a user;
		//But we don't usually use delete, if delete a user, the roles will also be deletes
		//which will affect other users with that role
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			session.delete(user);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testSave() {
		//Insert two users and each has two roles
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//1. Create two users
			User user1 = new User();
			user1.setUser_name("Lucy");
			user1.setUser_password("1314");
			User user2 = new User();
			user2.setUser_name("Mary");
			user2.setUser_password("520");
			
			//2. Create three roles
			Role role1 = new Role();
			role1.setRole_name("Software Developer");
			role1.setRole_memo("write code");
			
			Role role2 = new Role();
			role2.setRole_name("QA Automation");
			role2.setRole_memo("test code");
			
			Role role3 = new Role();
			role3.setRole_name("Team Lead");
			role3.setRole_memo("control code");
			
			//3. Build relationship, because you have "save-update" in user.hbm file
			//so here you only need operate one side of the relationship
			user1.getRoleSet().add(role1);
			user1.getRoleSet().add(role2);
			
			user2.getRoleSet().add(role2);
			user2.getRoleSet().add(role3);
			
			//4. Save 
			session.save(user1);
			session.save(user2);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
