import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class OrderApplication {
	private static ArrayList<Product> catalogue = new ArrayList<Product>();	//catalogue of products
	
	public static void main(String[] args) throws IOException {
		OrderApplication oa = new OrderApplication();
		Customer customer = new Customer("Nic Achter", "123 Road Ave", 0.0f, 0.0f);
		Order order = new Order(customer);
		Scanner in = new Scanner(System.in);	//input scanner
		int input = 0;							//user input for deciding to modify the order
		int itemID;								//ID of the item to be modified
		int quantity;							//quantity of item to modify
		
		//if an order can be created, print the price of the order
		if (oa.createOrder(order)) {
			System.out.printf("The price of the order is $%.1f\n", order.calculatePrice());
			System.out.printf("Would you like to modify the order (Enter 1 for yes)?");
			input = Integer.parseInt(in.nextLine());
			
			//if input is 1, modify the order
			if (input == 1) {
				System.out.printf("Enter the item ID of the item you want to modify: ");
				itemID = Integer.parseInt(in.nextLine());
				System.out.printf("Enter the new quantity of the item (Enter 0 to delete the item): ");
				quantity = Integer.parseInt(in.nextLine());
				
				order.modifyOrder(itemID, quantity);
			}
		}
		
		in.close();								//close the input scanner	
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