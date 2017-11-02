public class OrderLine {
	private int quantity;		//quantity of products
	private double price;		//price of order
	private Product product;	//a product
	
	//constructor
	OrderLine(Product product, int quantity, double price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	
	//getters
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
}
