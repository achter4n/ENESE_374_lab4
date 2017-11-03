import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class OrderApplication {
	private static ArrayList<Product> catalogue = new ArrayList<Product>();	//catalogue of products
	
	public static void main(String[] args) throws IOException {
		OrderApplication oa = new OrderApplication();
		Customer customer = new Customer("Nic Achter", "123 Road Ave", 0.0f, 0.0f);
		Order order = new Order(customer);
		
		//if an order can be created, print the price of the order
		if (oa.createOrder(order)) {
			System.out.printf("The price of the order is $%.1f\n", order.calculatePrice());
		}
	}
	
	//creates a new order
	public boolean createOrder(Order order) throws IOException {
		boolean open = importCatalogue();	//boolean to ensure that 

		//if the file opened properly
		if (open) {
			Iterator<Product> iterator = catalogue.iterator();	//iterator

			//while not the end of the list, add item
			while (iterator.hasNext()) {
				Product product = iterator.next();
				order.addItem(product, 1);
			}
		}
		return open;
	}

	//get the catalogue of items from a text file
	private boolean importCatalogue() throws IOException {
		boolean open = false;				//boolean for if the file opened
		Scanner in = null;					//input scanner
		try {
			in = new Scanner(Paths.get("ProductCatalogue.txt"));	//grab text from file
			//while not end of file
			while (in.hasNextLine()) {
				String[] data = in.nextLine().split(",");
				Product product = new Product(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));		
				catalogue.add(product);
			}
		}finally {
			//if the input isn't empty, close file and set open to true
			if (in != null) {
				in.close();
				open = true;
			}
		}
		return open;
	}
}