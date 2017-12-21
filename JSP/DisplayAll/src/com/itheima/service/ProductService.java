package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;

public class ProductService {

	public List<Product> findAll() throws SQLException {
		return new ProductDao().findAll();
	}

}
