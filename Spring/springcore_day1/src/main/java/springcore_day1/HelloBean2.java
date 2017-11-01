package springcore_day1;

public class HelloBean2 {
	private String beanName;

	public HelloBean2(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public void sayHello() {
		System.out.println("Hello " + beanName );
	}
}
