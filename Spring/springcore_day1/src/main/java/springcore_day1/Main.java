package springcore_day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
		HelloBean bean = (HelloBean) context.getBean("HelloBean");
		bean.sayHello();
	}
}
