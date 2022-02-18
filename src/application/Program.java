package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/YYYY");
		Order order = new Order();
		SimpleDateFormat sdf1 = new SimpleDateFormat ("dd/MM/YYYY HH:MM:ss");
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email:");
		String email = sc.next();
		System.out.print("BirthDate: (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		String orderData = sc.next();
		OrderStatus.valueOf(orderData);

		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter " +"#" +i + "item data: "  );
			System.out.print("Product name: ");
			String pName = sc.next();
			System.out.print("Product price: ");
			Double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			
			Product products = new Product(pName, pPrice);
			
			int orderQuantity = sc.nextInt();
			OrderItem item = new OrderItem(orderQuantity, pPrice, products);
			order.addItem(item);
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		
		sc.close();

	}

}
