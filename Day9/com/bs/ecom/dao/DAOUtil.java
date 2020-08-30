package Day9.com.bs.ecom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Day9.com.bs.ecom.beans.Product;

public class DAOUtil {
	
	static Connection con;
	static PreparedStatement ps;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "C##PRODUCT";
		String password = "product";
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection(url, username, password);
		
		System.out.println("Connection Established Successfully" + con);
		return con;
	}
	
}
