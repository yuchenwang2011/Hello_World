package com.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itcast.entity.ContactPerson;
import com.itcast.entity.Customer;
import com.itcast.hibernate.utils.HibernateUtils;

public class HibernateOneToMany {
	@Test
	public void testUpdate() {
		//a ContactPerson will go from Company A to Company B
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//Get first customer, while contact is now in the second customer
			Customer customer = session.get(Customer.class, 1);
			
			//The contact person is not in customer1 now
			ContactPerson contact = session.get(ContactPerson.class, 3);
			
			//Move contact to first customer
			customer.getContactPersonSet().add(contact);
			contact.setCustomer(customer);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testCascadeDelete() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//1. Add a customer
			Customer customer = session.get(Customer.class, 2);
			//because in the customer hbm file, you added "delete"
			//this delete will delete all the sub ContactPerson as well
			session.delete(customer);
			
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testCascadeAddEasierMethod() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//1. Add a customer
			Customer customer = new Customer();
			customer.setCustName("Apple");
			customer.setCustLevel("general customer");
			customer.setCustSource("Internet");
			customer.setCustPhone("45678");
			customer.setCustMobile("56789");
			
			//2. Create a contact person for the customer
			ContactPerson contact1 = new ContactPerson();
			contact1.setP_name("Tom");
			contact1.setP_gender("Male");
			contact1.setP_phone("2999 ");
			
			//3. Build the relationship between customer and contact
			customer.getContactPersonSet().add(contact1);
			//if in the customer hbm file you have added "casacde: save-update", you don't need below
			//contact1.setCustomer(customer);
			
			//4. Add to database
			session.save(customer);
			session.save(contact1);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testCascadeAddTediousMethod() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			//1. Add a customer
			Customer customer = new Customer();
			customer.setCustName("Google");
			customer.setCustLevel("vip");
			customer.setCustSource("Internet");
			customer.setCustPhone("12345");
			customer.setCustMobile("23456");
			
			//2. Create a contact person for the customer
			ContactPerson contact1 = new ContactPerson();
			contact1.setP_name("Lucy");
			contact1.setP_gender("Female");
			contact1.setP_phone("1999 ");
			
			//3. Build the relationship between customer and contact
			customer.getContactPersonSet().add(contact1);
			//if in the customer hbm file you have added "casacde: save-update", you don't need below
			contact1.setCustomer(customer);
			
			//4. Add to database
			session.save(customer);
			session.save(contact1);
			
			tx.commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
