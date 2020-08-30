package Day9.com.bs.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public class ProductDAOImpl implements ProductDAO {

	ArrayList<Product> products;
	Connection con;
	PreparedStatement ps;

	public ProductDAOImpl() throws ClassNotFoundException, SQLException {
		con = DAOUtil.getConnection();
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		String query = "select * from ecom_products";
		ps = con.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		List<Product> products = new ArrayList<>();

		while (rs.next()) {
			int pid = rs.getInt(1);
			String pname = rs.getString(2);
			int pcost = rs.getInt(3);
			int prating = rs.getInt(4);

			products.add(new Product(pid, pname, pcost, prating));
		}

		return products;
	}

	@Override
	public List<Product> getProductsByCost(int cost) throws SQLException {
		String query = "select * from ecom_products where pcost = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, cost);

		ResultSet rs = ps.executeQuery();

		List<Product> resultList = new ArrayList<>();

		while (rs.next()) {
			int pid = rs.getInt(1);
			String pname = rs.getString(2);
			int pcost = rs.getInt(3);
			int prating = rs.getInt(4);

			resultList.add(new Product(pid, pname, pcost, prating));
		}

		return resultList;
	}

	@Override
	public Product getProductsById(int searchID) throws NoSuchProductExecption, SQLException {

		String query = "select * from ecom_products where pid = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, searchID);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Product p = new Product();
				int pid = rs.getInt(1);
				String pname = rs.getString(2);
				int pcost = rs.getInt(3);
				int prating = rs.getInt(4);

				p.setPid(pid);
				p.setProductName(pname);
				p.setCost(pcost);
				p.setStarRating(prating);

			return p;

		} else {
			throw new NoSuchProductExecption("Wrong Product Id " + searchID);

		}
	}

	@Override
	public boolean addProduct(int pid, String productName, int cost, double starRating) throws SQLException {

		String query = "insert into ECOM_PRODUCTS values(?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1, pid);
		ps.setString(2, productName);
		ps.setInt(3, cost);
		ps.setDouble(4, starRating);

		int i = ps.executeUpdate();
		if (i > 0)
			return true;

		return false;

	}

	@Override
	public boolean deleteProduct(int pid) throws SQLException {
		String query = "DELETE FROM ECOM_PRODUCTS WHERE pid = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, pid);

		int i = ps.executeUpdate();
		if (i > 0)
			return true;

		return false;
	}

	@Override
	public boolean updateProduct(int pid, String productName, int cost, double starRating) throws SQLException {

		String query = "update ECOM_PRODUCTS set pname = ?, pcost = ?, prating = ? where pid = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, productName);
		ps.setInt(2, cost);
		ps.setDouble(3, starRating);
		ps.setInt(4, pid);

		int i = ps.executeUpdate();
		if (i > 0)
			return true;

		return false;
	}
}
