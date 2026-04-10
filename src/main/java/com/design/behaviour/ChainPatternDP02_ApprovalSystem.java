package com.design.behaviour;
/*
 * 
 * Approval workflows (like your claim approval / pre-auth logic)
   Logging frameworks
    Spring Security filters
 * 
 * */
class Order {

	private int orderId;
	private double amount;

	public Order(int orderId, double amount) {
		this.orderId = orderId;
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public double getAmount() {
		return amount;
	}
}

abstract class Approver {
	protected Approver nextApprover;

	public void setNextApprover(Approver nextApprover) {
		this.nextApprover = nextApprover;
	}

	public abstract void approveOrder(Order order);
}

class Manager extends Approver {

	@Override
	public void approveOrder(Order order) {
		if (order.getAmount() <= 10000) {
			System.out.println("Manager approved order " + order.getOrderId());
		} else if (nextApprover != null) {
			nextApprover.approveOrder(order);
		}
	}
}

class Director extends Approver {

    @Override
    public void approveOrder(Order order) {
        if (order.getAmount() <= 50000) {
            System.out.println("Director approved order " + order.getOrderId());
        } else if (nextApprover != null) {
            nextApprover.approveOrder(order);
        }
    }
}

class CEO extends Approver {

    @Override
    public void approveOrder(Order order) {
        System.out.println("CEO approved order " + order.getOrderId());
    }
}

public class ChainPatternDP02_ApprovalSystem {

	public static void main(String[] args) {
		Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        // Set chain
        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        // Test orders
        Order order1 = new Order(101, 5000);
        Order order2 = new Order(102, 20000);
        Order order3 = new Order(103, 100000);

        manager.approveOrder(order1);
        manager.approveOrder(order2);
        manager.approveOrder(order3);
	}
}
