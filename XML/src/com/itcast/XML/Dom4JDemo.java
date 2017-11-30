package com.itcast.XML;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4JDemo {
	public static void main(String[] args) {
		String path = "/Users/yuchenwang/Github/Hello_World/XML/XML/Demo.xml";
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read(path);
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			for(Element ele : elements) {
				String servletName = ele.elementText("servlet-name");
				System.out.println(servletName);
				
				String urlPattern = ele.elementText("url-pattern");
				System.out.println(urlPattern);
			}
			
			String rootAtt = root.attributeValue("version");
			System.out.println(rootAtt);
			
			//user jaxen jar file to select a single element using XPath
			// "/" to select from the root level
			// "//" to select all the elements
			Node servletClass = doc.selectSingleNode("/web-app/servlet/servlet-class");
			System.out.println(servletClass.getText());
			
			Node webApp = doc.selectSingleNode("web-app[@version=2.5]");
			System.out.println(webApp.getName());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
