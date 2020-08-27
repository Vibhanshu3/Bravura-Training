package Day6;

import java.util.Comparator;

public class ProductSortOnStarRating implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		return p2.getStarRating() - p1.getStarRating();
	}

}
