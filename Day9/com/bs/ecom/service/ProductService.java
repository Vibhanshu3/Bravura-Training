package Day9.com.bs.ecom.service;

import java.sql.SQLException;
import java.util.List;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.execptions.NoSuchProductExecption;

public interface ProductService {
	public List<Product> getAllProducts() throws SQLException;

	public List<Product> getProductsByCost(int cost) throws SQLException;

	public Product getProductsById(int searchId) throws NoSuchProductExecption, SQLException;

	public boolean addProduct(int pid, String productName, int cost, double starRating) throws SQLException;
	
	public boolean deleteProduct(int pid) throws SQLException;
	
	public boolean updateProduct(int pid, String productName, int cost, double starRating) throws SQLException;

}
