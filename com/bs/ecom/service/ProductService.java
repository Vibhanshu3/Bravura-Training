package com.bs.ecom.service;

import java.util.List;

import com.bs.ecom.beans.Product;
import com.bs.ecom.execptions.NoSuchProductExcption;

public interface ProductService {
	public List<Product> getAllProducts();

	public List<Product> getProductsByCost(int cost);

	public Product getProductsById(int searchId) throws NoSuchProductExcption;

	public void addProduct(int pid, String productName, int cost, int starRating);

}
