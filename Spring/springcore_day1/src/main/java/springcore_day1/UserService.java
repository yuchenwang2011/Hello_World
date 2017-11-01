package springcore_day1;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void printInfo() {
		System.out.println("This is a UserService and Dao: " + userDao.toString());
		userDao.printInfo();
	}
}
