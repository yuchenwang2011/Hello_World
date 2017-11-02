package springcore_day2;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

	private static ApplicationContext context;
	private static Logger log;
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User user1 = (User) context.getBean("user");
		User user2 = (User) context.getBean("user");
		//prototype annotation
		System.out.println(user1);
		user1.add();
		System.out.println(user2);
		
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
		
		context = new ClassPathXmlApplicationContext("ApplicationContextAOP.xml");
		Book book = (Book) context.getBean("book");
		book.printInfo();
		log = Logger.getLogger(TestAnnotation.class.getName());
		log.info("this is info from log4j");
		log.warn("this is warn from log4j");
		log.debug("this is debug from log4j");
	}
}
