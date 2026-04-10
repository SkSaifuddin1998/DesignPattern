package com.design.behaviour;

interface OrderCommand {
	void execute();
}

class OrderService {

	public void placeOrder(int orderId) {
		System.out.println("Order " + orderId + " placed successfully");
	}

	public void cancelOrder(int orderId) {
		System.out.println("Order " + orderId + " cancelled");
	}
}

class PlaceOrderCommand implements OrderCommand {

	private OrderService orderService;
	private int orderId;

	public PlaceOrderCommand(OrderService orderService, int orderId) {
		this.orderService = orderService;
		this.orderId = orderId;
	}

	@Override
	public void execute() {
		orderService.placeOrder(orderId);
	}
}

class CancelOrderCommand implements OrderCommand {

	private OrderService orderService;
	private int orderId;

	public CancelOrderCommand(OrderService orderService, int orderId) {
		this.orderService = orderService;
		this.orderId = orderId;
	}

	@Override
	public void execute() {
		orderService.cancelOrder(orderId);
	}
}

class OrderInvoker {

	private OrderCommand command;

	public void setCommand(OrderCommand command) {
		this.command = command;
	}

	public void process() {
		command.execute();
	}
}

public class CommandDP02_OrderProcessingSystem {

	public static void main(String[] args) {

		OrderService orderService = new OrderService();

		// Create commands
		OrderCommand placeOrder = new PlaceOrderCommand(orderService, 101);
		OrderCommand cancelOrder = new CancelOrderCommand(orderService, 102);

		// Invoker
		OrderInvoker invoker = new OrderInvoker();

		// Execute place order
		invoker.setCommand(placeOrder);
		invoker.process();

		// Execute cancel order
		invoker.setCommand(cancelOrder);
		invoker.process();

	}

}
