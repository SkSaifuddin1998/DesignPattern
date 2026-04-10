package com.design.behaviour;

import java.util.ArrayList;
import java.util.List;

interface ObserverSubject {

	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers();
}

class ObserverOrder implements Subject {

	private List<Observer> observers = new ArrayList<>();
	private String status;
	private int orderId;

	public ObserverOrder(int orderId) {
		this.orderId = orderId;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyObservers();
	}

	public String getStatus() {
		return status;
	}

	public int getOrderId() {
		return orderId;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(status);
		}
	}
}

class Customer implements Observer {

	private String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public void update(String status) {
		System.out.println("Customer " + name + " notified: Order status changed to " + status);
	}
}

class DeliveryService implements Observer {

	@Override
	public void update(String status) {
		System.out.println("Delivery Service notified: Order is now " + status);
	}
}

class Warehouse implements Observer {

	@Override
	public void update(String status) {
		System.out.println("Warehouse notified: Prepare order for status " + status);
	}
}

public class ObserverDP02_OrderStatusUpdate {

	public static void main(String[] args) {

		ObserverOrder order = new ObserverOrder(101);

		// Create observers
		Observer customer = new Customer("Sujan");
		Observer warehouse = new Warehouse();
		Observer delivery = new DeliveryService();

		// Register observers
		order.addObserver(customer);
		order.addObserver(warehouse);
		order.addObserver(delivery);

		// Change order status
		order.setStatus("PLACED");
		order.setStatus("SHIPPED");
		order.setStatus("DELIVERED");
	}

}
