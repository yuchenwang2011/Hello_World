package springcore_day2;

import org.springframework.stereotype.Component;

@Component(value="userDao")
public class UserDao {
	public void add() {
		System.out.println("This is add from Dao");
	}
}
