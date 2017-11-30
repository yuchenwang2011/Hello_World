package com.itcast.example;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.itcast.HelloMyServlet;

public class Example {
	@Test
	public void test1() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("/hello", "com.itcast.HelloMyServlet");
		String value = map.get("/hello");
		Class clazz = Class.forName(value);
		HelloMyServlet servlet = (HelloMyServlet) clazz.newInstance();
		Method method = clazz.getMethod("add");
		method.invoke(servlet);
	}
	
	@Test
	public void test2() throws Exception {
		Document doc = new SAXReader().read("/Users/yuchenwang/Github/Hello_World/XML/XML/Demo.xml");
		String urlPattern = doc.selectSingleNode("/web-app/servlet-mapping/url-pattern").getText();
		String className = doc.selectSingleNode("/web-app/servlet/servlet-class").getText();
		Map<String, String> map = new HashMap<String, String>();
		map.put(urlPattern, className);
		String value = map.get("/hello");
		Class clazz = Class.forName(value);
		HelloMyServlet servlet = (HelloMyServlet) clazz.newInstance();
		Method method = clazz.getMethod("add");
		method.invoke(servlet);
	}
}
