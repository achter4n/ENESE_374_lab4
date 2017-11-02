public class Product {
	private String name;			//name of product
	private double price;			//price of product
	private int productID;			//ID of product

	//constructor
	public Product(String name, double price, int productID) {
		this.name = name;
		this.price = price;
		this.productID = productID;
	}
	
	//getters
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getProductID() {
		return productID;
	}
}
