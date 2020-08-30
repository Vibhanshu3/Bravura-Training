package Day9.com.bs.ecom.view;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Day9.com.bs.ecom.beans.Product;
import Day9.com.bs.ecom.service.ProductService;
import Day9.com.bs.ecom.service.ProductServiceImpl;

public class MainClass {
	static Scanner sc = new Scanner(System.in);
	ProductService productService;

	public MainClass() {
		try {
			productService = new ProductServiceImpl();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			System.out.println("5. DELETE PRODUCT");
			System.out.println("6. UPDATE PRODUCT");
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

			case 5:
				obj.deleteProduct();
				break;

			case 6:
				obj.updateProduct();
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
		try {
			List<Product> products = productService.getAllProducts();
			Iterator<Product> iterator = products.iterator();
			while (iterator.hasNext()) {
				Product p = iterator.next();
				System.out.println(p.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void productByCost() {
		System.out.println("ENTER THE SEARCHED PRODUCT COST");
		int cost = sc.nextInt();

		try {
			List<Product> products = productService.getProductsByCost(cost);
			Iterator<Product> iterator = products.iterator();

			while (iterator.hasNext()) {
				Product p = iterator.next();
				System.out.println(p.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void productByID() {
		System.out.println("ENTER THE SEARCHED PRODUCT ID");
		int id = sc.nextInt();

		try {
			Product p = productService.getProductsById(id);
			System.out.println(p);

		} catch (Exception e) {
			e.printStackTrace();

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
		double starRating = sc.nextDouble();

		try {
			boolean result = productService.addProduct(pid, productName, cost, starRating);

			if (result)
				System.out.println("NEW PRODUCT ADDED SUCCESSFULLY");
			else {
				System.out.println("SOMETHING WENT WRONG");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void deleteProduct() {
		System.out.println("ENTER PRODUCT ID TO BE DELETED:");
		int pid = sc.nextInt();

		try {
			boolean result = productService.deleteProduct(pid);

			if (result)
				System.out.println("PRODUCT DELETED SUCCESSFULLY");
			else {
				System.out.println("SOMETHING WENT WRONG");

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void updateProduct() {
		System.out.println("ENTER PRODUCT ID TO BE UPDATED:");
		int pid = sc.nextInt();

		System.out.println("ENTER NEW DATA TO BE UPDATED");

		System.out.println("Enter product name");
		String productName = sc.next();

		System.out.println("Enter product cost");
		int cost = sc.nextInt();

		System.out.println("Enter product star rating");
		double starRating = sc.nextDouble();

		try {
			boolean result = productService.updateProduct(pid, productName, cost, starRating);

			if (result)
				System.out.println("PRODUCT UPDATED SUCCESSFULLY");

			else {
				System.out.println("SOMETHING WENT WRONG");

			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
