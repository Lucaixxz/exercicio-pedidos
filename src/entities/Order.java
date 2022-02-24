package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY HH:MM:ss");

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItem() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Date moment = new Date();
		sb.append("Order moment: ");
		sb.append(sdf2.format(moment) + "\n");
		sb.append("Order status: " + OrderStatus.valueOf("PROCESSING") + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: " + "\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total Price: " + "\n");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
