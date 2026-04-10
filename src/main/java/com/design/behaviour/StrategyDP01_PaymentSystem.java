package com.design.behaviour;

/*
 * Payment gateways (Razorpay, Stripe, etc.)
   Claim settlement modes (cashless / reimbursement)
   Discount calculation strategies
   Authentication methods (OAuth, JWT, etc.)
 * 
 * */
interface PaymentStrategy {
	void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {

	private String cardNumber;

	public CreditCardPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
	}
}

class UPIPayment implements PaymentStrategy {

	private String upiId;

	public UPIPayment(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
	}
}

class PayPalPayment implements PaymentStrategy {

	private String email;

	public PayPalPayment(String email) {
		this.email = email;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using PayPal: " + email);
	}
}

class PaymentContext {

	private PaymentStrategy paymentStrategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void makePayment(double amount) {
		if (paymentStrategy == null) {
			throw new RuntimeException("Payment method not selected");
		}
		paymentStrategy.pay(amount);
	}
}

public class StrategyDP01_PaymentSystem {

	public static void main(String[] args) {

		PaymentContext context = new PaymentContext();

		// Pay using Credit Card
		context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012"));
		context.makePayment(5000);

		// Pay using UPI
		context.setPaymentStrategy(new UPIPayment("sujan@upi"));
		context.makePayment(1500);

		// Pay using PayPal
		context.setPaymentStrategy(new PayPalPayment("sujan@gmail.com"));
		context.makePayment(3000);
	}

}
