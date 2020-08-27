package com.bs.ecom.dao;

import java.util.List;

import com.bs.ecom.beans.Product;
import com.bs.ecom.execptions.NoSuchProductExcption;

public interface ProductDAO {
	public List<Product> getAllProducts();

	public List<Product> getProductsByCost(int cost);

	public Product getProductsById(int serachedId) throws NoSuchProductExcption;

	public void addProduct(int pid, String productName, int cost, int starRating);
}
