package com.bs.ecom.dao;

import java.util.ArrayList;

import com.bs.ecom.beans.Product;

public class DAOUtil {
	// connection code

	static ArrayList<Product> products = new ArrayList<>(); // act as our database , Oracle , MySQL, DB2

	public static ArrayList<Product> getProductDatabase() {
		// get database connection

		products.add(new Product(101, "HP-Laptop", 2000, 4));
		products.add(new Product(102, "HP-Laptop", 2500, 2));
		products.add(new Product(103, "HP-Laptop", 12000, 5));

		return products;
	}
}
