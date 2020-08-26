package Day6;

public class Product implements Comparable<Product> {
	private int pid;
	private String productName;
	private int cost;
	private int starRating;

	public Product() {
		super();
	}

	public Product(int pid, String productName, int cost, int starRating) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.cost = cost;
		this.starRating = starRating;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + pid;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + starRating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (cost != other.cost)
			return false;
		if (pid != other.pid)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (starRating != other.starRating)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", cost=" + cost + ", starRating=" + starRating
				+ "]";
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.pid - o.pid;
	}

	
	

}
