package springcore_day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userService")  //value is not necessary, equal to: @Service("userService")
public class UserService {
	
	@Autowired
	//@resource(name="userDao") is also ok
	private UserDao userDao;

//Using annotation, No need to use setter, the DI is realized by adding annotation on property
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	
	public void add() {
		System.out.println("========");
		System.out.println("This is add from Service");
		userDao.add();
	}
}
