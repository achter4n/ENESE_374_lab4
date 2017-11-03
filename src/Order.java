import java.util.*;

public class Order {
	private Date dateReceived;							//date order was received on
	private double price;								//price of the order
	private int orderID;								//ID for the order
	private Customer customer;							//customer making the order
	public ArrayList<OrderLine> ol = new ArrayList<OrderLine>();	//list of products in the order line
	
	//constructor
	public Order(Customer customer) {
		dateReceived = new Date();
		price = 0;
		orderID = 1;
		this.customer = customer;
	}
	
	//getter for date
	public Date getDateReceived() {
		return dateReceived;
	}

	//calculates the order price
	public double calculatePrice() {
		Iterator<OrderLine> iterator = ol.iterator();	//iterator to iterate through the list
		OrderLine currentOrder;							//current order in the line
		Product currentProduct;							//current product being looked at
		double currentPrice;							//price of the current product
		
		//while not at the end of the list
		while(iterator.hasNext()) {
			currentOrder = iterator.next();
			currentProduct = currentOrder.getProduct();
			currentPrice = currentProduct.getPrice();
			currentPrice *= currentOrder.getQuantity();
			price += currentPrice;
		}
		price -= price * customer.getDiscountRating();	//applied customer's discount
		return price;
	}
	
	//adds a new item to the order
	public void addItem(Product product, int quantity) {
		OrderLine newOrder = new OrderLine(product, quantity, product.getPrice());
		ol.add(newOrder);
	}
	
	//modifies the quantity of an item
	public void modifyOrder (int itemID, int newQuantity) {
		Iterator<OrderLine> iterator = ol.iterator();	//iterator to iterate through the list
		Product currentProduct;							//curent product being checked
		
		//while not at the end of the list
		while(iterator.hasNext()) {
			currentProduct = (iterator.next().getProduct());
			
			//if the ID matches the current product, set the new quantity
			if(currentProduct.getProductID() == itemID) {
				iterator.next().setQuantity(newQuantity);
			}
		}
	}
}