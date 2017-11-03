
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class OrderApplication {
	private static ArrayList<Product> products = new ArrayList<Product>();
	
	public static void main(String[] args) throws IOException {
		OrderApplication oa = new OrderApplication();
		Customer customer = new Customer("Nic Achter", "123 Road Ave", 0.0f, 0.0f);
		Order order = new Order(customer);
		
		if (createOrder(order)) {
			System.out.printf("The price of the order is $%.1f\n", order.calculatePrice());
		}
	}
	
	public static boolean createOrder(Order order) throws IOException {
		boolean open = importCatalogue();

		if (open) {
			Iterator<Product> iterator = products.iterator();

			while (iterator.hasNext()) {
				Product product = iterator.next();
				order.addItem(product, 1);
			}
		}
		return open;
	}

	private static boolean importCatalogue() throws IOException {
		boolean open = false;
		Scanner in = null;
		try {
			in = new Scanner(Paths.get("ProductCatalogue.txt"));
			while (in.hasNextLine()) {
				String[] data = in.nextLine().split(",");
				Product product = new Product(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));		
				products.add(product);
			}
		}finally {
			if (in != null) {
				in.close();
				open = true;
			}
		}
		return open;
	}
}