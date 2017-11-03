
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class OrderApplicaion {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public static void main(String[] args) throws IOException {
		OrderApplicaion oa = new OrderApplicaion();
		Order order = new Order();
		
		if (!oa.importCatalogue()) {
			System.out.print("File was unable to open.");
			return;
		}
		oa.createOrder(order);
		
		order.calculatePrice();
	}
	
	public boolean createOrder(Order order) throws IOException {
		boolean open = this.importCatalogue();

		if (open) {
			Iterator<Product> iterator = products.iterator();

			while (iterator.hasNext()) {
				Product product = iterator.next();
				order.addItem(product, 1);
			}
		}
		return open;
	}

	private boolean importCatalogue() throws IOException {
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