package com.bs.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public interface UserDAO {
	public boolean loginUser(String username, String password) throws SQLException;

	public boolean registerUser(String username, String password) throws SQLException;
}
