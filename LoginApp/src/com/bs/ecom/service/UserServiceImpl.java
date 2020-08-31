package com.bs.ecom.service;

import java.sql.SQLException;
import java.util.List;

import com.bs.ecom.dao.UserDAO;
import com.bs.ecom.dao.UserDAOImpl;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.dao.ProductDAO;
import Day9.com.bs.ecom.dao.ProductDAOImpl;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	public UserServiceImpl() throws ClassNotFoundException, SQLException {
		userDAO = new UserDAOImpl();
	}

	@Override
	public boolean loginUser(String username, String password) throws SQLException {
		return userDAO.loginUser(username, password);
	}

	@Override
	public boolean registerUser(String username, String password) throws SQLException {
		return userDAO.registerUser(username, password);
	}

}
