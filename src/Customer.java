public class Customer {
	private String name;			//name of customer
	private String address;			//customer's address
	private float creditRating;		//customer's credit rating
	private float discountRating;	//customer's discoutn rating
	
	//constructor
	public Customer(String name, String address, float creditRating, float discountRating) {
		this.name = name;
		this.address = address;
		this.creditRating = creditRating;
		this.discountRating = discountRating;
	}
	
	//getters
	public float getCreditRating() {
		return creditRating;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public float getDiscountRating() {
		return discountRating;
	}
}
