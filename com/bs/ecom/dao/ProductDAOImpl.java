package com.bs.ecom.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bs.ecom.beans.Product;
import com.bs.ecom.execptions.NoSuchProductExcption;

public class ProductDAOImpl implements ProductDAO {

	ArrayList<Product> products;

	public ProductDAOImpl() {
		products = DAOUtil.getProductDatabase(); // product database table
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public List<Product> getProductsByCost(int cost) {
		// sql to get product by cost
		List<Product> tempList = new ArrayList<>();

		Iterator<Product> itr = products.iterator();

		while (itr.hasNext()) {
			Product p = itr.next();
			if (p.getCost() == cost) {
				tempList.add(p);
			}
		}

		return tempList;
	}

	@Override
	public Product getProductsById(int searchID) throws NoSuchProductExcption {
		Iterator<Product> itr = products.iterator();

		boolean found = false;
		Product p = null;

		while (itr.hasNext()) {
			p = itr.next();
			if (p.getPid() == searchID) {
				found = true;
				break;

			}
		}

		if (found == false)
			throw new NoSuchProductExcption("Wrong Product Id " + searchID);
		else
			return p;

	}

	@Override
	public void addProduct(int pid, String productName, int cost, int starRating) {
		Product p = new Product();

		p.setPid(pid);
		p.setProductName(productName);
		p.setCost(cost);
		p.setStarRating(starRating);
		
		products.add(p);

	}

}
