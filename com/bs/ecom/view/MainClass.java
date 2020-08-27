package com.bs.ecom.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bs.ecom.beans.Product;
import com.bs.ecom.service.ProductService;
import com.bs.ecom.service.ProductServiceImpl;

public class MainClass {

	static Scanner sc = new Scanner(System.in);
	ProductService productService;

	public MainClass() {
		productService = new ProductServiceImpl();

	}

	public static void main(String[] args) {
		MainClass obj = new MainClass();

		int choice = 0;

		do {
			System.out.println("-------------------------");
			System.out.println("WELCOME TO PRODUCTS APP");
			System.out.println("1. GET ALL PRODUCTS");
			System.out.println("2. SEARCH PRODUCT BY ID");
			System.out.println("3. SEARCH PRODUCT BY COST");
			System.out.println("4. ADD A NEW PRODUCT");
			System.out.println("0. EXIT");
			System.out.println("-------------------------");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				obj.getAllProducts();
				break;

			case 2:
				obj.productByID();
				break;

			case 3:
				obj.productByCost();
				break;

			case 4:
				obj.addNewProduct();
				break;

			case 0:
				System.out.println("THANK YOU! EXITING>");
				break;
				
			default:
				System.out.println("INVALID INPUT");
				break;
			}
		} while (choice != 0);

	}

	public void getAllProducts() {
		List<Product> products = productService.getAllProducts();

		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product p = iterator.next();
			System.out.println(p.toString());
		}
	}

	public void productByCost() {
		System.out.println("Enter the Searched Product cost");
		int cost = sc.nextInt();

		List<Product> products = productService.getProductsByCost(cost);
		Iterator<Product> iterator = products.iterator();

		while (iterator.hasNext()) {
			Product p = iterator.next();
			System.out.println(p.toString());
		}

	}

	public void productByID() {
		System.out.println("Enter the Searched Product ID ");
		int id = sc.nextInt();

		try {
			Product p = productService.getProductsById(id);
			System.out.println(p);

		} catch (Exception e) {
			System.out.println(e);
		
		}

	}

	public void addNewProduct() {
		System.out.println("Enter product id");
		int pid = sc.nextInt();

		System.out.println("Enter product name");
		String productName = sc.next();

		System.out.println("Enter product cost");
		int cost = sc.nextInt();

		System.out.println("Enter product star rating");
		int starRating = sc.nextInt();

		productService.addProduct(pid, productName, cost, starRating);
	}

}
