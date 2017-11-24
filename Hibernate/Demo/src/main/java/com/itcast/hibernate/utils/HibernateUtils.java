package com.itcast.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final Configuration cfg;
	private static final SessionFactory sessionFactory;
	static {
		cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//but for a web project, you can't close it, because static block only executes once.
	public static void closeResource(Session session, SessionFactory sessionFactory) {
		if(session != null) {
			session.close();
		}
		if(sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
