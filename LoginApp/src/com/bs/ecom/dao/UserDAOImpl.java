package com.bs.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public class UserDAOImpl implements UserDAO {

	Connection con;
	PreparedStatement ps;

	public UserDAOImpl() throws ClassNotFoundException, SQLException {
		con = DAOUtil.getConnection();
	}

	@Override
	public boolean loginUser(String username, String password) throws SQLException {
		String query = "select username from ecom_users where password = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, password);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean registerUser(String username, String password) throws SQLException {
		String query = "insert into ECOM_USERS (USERNAME, PASSWORD) values(?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);

		int i = ps.executeUpdate();
		if (i > 0)
			return true;

		return false;

	}
}
