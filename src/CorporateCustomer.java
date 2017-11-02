public class CorporateCustomer extends Customer{
	private String contactName;		//contact name for corporate customer
	
	//constructor
	public CorporateCustomer(String name, String address, float creditRating, float discountRating, String contactName) {
		super(name, address, creditRating, discountRating);
		this.contactName = contactName;
	}
}
