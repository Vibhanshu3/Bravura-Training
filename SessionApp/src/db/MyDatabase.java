package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.Product;

public class MyDatabase {
	public static Map<String, List<Product>> products = new HashMap<>();

	static {
		List<Product> laptopList = new ArrayList<>();
		laptopList.add(new Product("Hp101", 2000));
		laptopList.add(new Product("Dell101", 3000));
		laptopList.add(new Product("Apple1", 20000));

		List<Product> watchlist = new ArrayList<>();
		watchlist.add(new Product("Fasttrack1", 1000));
		watchlist.add(new Product("Fasttrack2", 3000));
		watchlist.add(new Product("Fasttrack3", 20000));

		products.put("Laptop", laptopList);
		products.put("Watch", watchlist);
		products.put("Mobile Phones", null);

	}

	public static Product getProductByName(String pname) {
		Iterator<String> itr_map = products.keySet().iterator();
		while (itr_map.hasNext()) {
			String keyword = itr_map.next(); // keyword

			List<Product> list = products.get(keyword);

			for (Product p : list) {
				if (pname.equals(p.getProductName())) {
					return p;
				}
			}
		}

		return null;
	}

	public static List<Product> getProductsByKeyword(String requestedkeyword) {
		Iterator<String> itr = products.keySet().iterator();

		while (itr.hasNext()) {
			String keyword = itr.next(); // key
			if (keyword.equals(requestedkeyword)) {
				List<Product> listOfProducts = products.get(keyword);
				return listOfProducts;

			}
		}
		return null;
	}
}
