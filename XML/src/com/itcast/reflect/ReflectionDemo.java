package com.itcast.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

import com.itcast.HelloMyServlet;

public class ReflectionDemo {
	@Test
	public void f1() {
		HelloMyServlet servlet = new HelloMyServlet();
		servlet.add();
		servlet.add(1);
		servlet.add(2,3);
	}

	@Test
	public void f2() throws Exception {
		Class clazz = Class.forName("com.itcast.HelloMyServlet");
		//Use the no-parameter constructor
		Object obj = clazz.newInstance();
		HelloMyServlet servlet = (HelloMyServlet) obj;
		servlet.add();
		servlet.add(2);
		servlet.add(3,4);
	}
	
	@Test
	public void f3() throws Exception {
		Class clazz = Class.forName("com.itcast.HelloMyServlet");
		Method method = clazz.getMethod("add");
		//invoke needs two parameter
		//first is a real object owns the method
		//second is the args to run this method
		method.invoke(clazz.newInstance());
	}
	
	@Test
	public void f4() throws Exception {
//		Class clazz = Class.forName("com.itcast.HelloMyServlet");
		Class clazz = new HelloMyServlet().getClass();
		Method method = clazz.getMethod("add", int.class);
		HelloMyServlet servlet = (HelloMyServlet) clazz.newInstance();
		method.invoke(servlet, 3);
	}
	
	@Test
	public void f5() throws Exception, IllegalAccessException {
//		Class clazz = Class.forName("com.itcast.HelloMyServlet");
		Class clazz = HelloMyServlet.class;
		HelloMyServlet servlet = (HelloMyServlet) clazz.newInstance();
		Method method = clazz.getMethod("add", int.class, int.class);
		method.invoke(servlet, 5,6);
	}
}
