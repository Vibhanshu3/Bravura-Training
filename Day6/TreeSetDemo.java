package Day6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Product> set = new TreeSet<>();
		
		set.add(new Product(5, "knife", 60, 5));
		set.add(new Product(1, "soap", 10, 4));
		set.add(new Product(3, "chair", 250, 3));
		set.add(new Product(4, "toy", 50, 2));
		set.add(new Product(2, "bed", 1000, 5));

		List<Product> list = new ArrayList<>();
		list.addAll(set);
		Collections.sort(list, new ProductSortOnStarRating());
		System.out.println(list);
//		displayProducts(set);

	}
	
	public static void displayProducts(Collection<Product> products)
	{
		for (Product p : products) {
			System.out.println("\n"+p);
		}
		
	}

}
