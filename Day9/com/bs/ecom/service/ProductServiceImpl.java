package Day9.com.bs.ecom.service;

import java.sql.SQLException;
import java.util.List;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.dao.ProductDAO;
import Day9.com.bs.ecom.dao.ProductDAOImpl;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public class ProductServiceImpl implements ProductService {

	ProductDAO productDAO;

	public ProductServiceImpl() throws ClassNotFoundException, SQLException {
		productDAO = new ProductDAOImpl();
	}

	@Override
	public List<Product> getAllProducts() throws SQLException {
		return productDAO.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCost(int cost) throws SQLException {
		return productDAO.getProductsByCost(cost);
	}

	@Override
	public Product getProductsById(int searchId) throws NoSuchProductExecption, SQLException {
		return productDAO.getProductsById(searchId);
	}

	@Override
	public boolean addProduct(int pid, String productName, int cost, double starRating) throws SQLException {
		return productDAO.addProduct(pid, productName, cost, starRating);
	}

	@Override
	public boolean deleteProduct(int pid) throws SQLException {
		return productDAO.deleteProduct(pid);
	}

	@Override
	public boolean updateProduct(int pid, String productName, int cost, double starRating) throws SQLException {
		return productDAO.updateProduct(pid, productName, cost, starRating);
	}

}
