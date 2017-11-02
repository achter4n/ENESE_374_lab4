import java.util.Date;

public class Order {
	private Date dateReceived;
	private Double price;
	private int orderID;
	
	public Date getDateReceived() {
		return dateReceived;
	}
	
	public Double calculatePrice() {
		return price;
	}
}
