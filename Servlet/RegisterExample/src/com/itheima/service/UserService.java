package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {

	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return User 用户
	 * @throws SQLException 
	 */
	public User login(String username, String password) throws SQLException {
		//调用dao
		UserDao dao=new UserDao();
		
		return dao.getUserByUsernameAndPwd(username,password);
	}

	public int register(User user) throws SQLException {
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}

}

