package springcore_day2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="user") //equal to: <bean id="user" class=""></bean>
//you can also write Controller/Service, they are the same, 
//Component for Web, Service for Logic
@Scope(value="prototype")
public class User {
	public void add() {
		System.out.println("Adding...");
	}
}
