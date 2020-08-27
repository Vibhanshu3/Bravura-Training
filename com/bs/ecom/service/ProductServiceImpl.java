package com.bs.ecom.service;

import java.util.List;

import com.bs.ecom.beans.Product;
import com.bs.ecom.dao.ProductDAO;
import com.bs.ecom.dao.ProductDAOImpl;
import com.bs.ecom.execptions.NoSuchProductExcption;

public class ProductServiceImpl implements ProductService {

	ProductDAO productDAO;

	public ProductServiceImpl() {
		productDAO = new ProductDAOImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public List<Product> getProductsByCost(int cost) {
		return productDAO.getProductsByCost(cost);
	}

	@Override
	public Product getProductsById(int searchId) throws NoSuchProductExcption {
		return productDAO.getProductsById(searchId);
	}

	@Override
	public void addProduct(int pid, String productName, int cost, int starRating) {
		productDAO.addProduct(pid, productName, cost, starRating);
	}

}
