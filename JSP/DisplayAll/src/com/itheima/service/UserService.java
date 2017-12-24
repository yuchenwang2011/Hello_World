package com.itheima.service;

import java.sql.SQLException;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserService {

	public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
		return new UserDao().getUserByUsernameAndPassword(username, password);
	}

}
