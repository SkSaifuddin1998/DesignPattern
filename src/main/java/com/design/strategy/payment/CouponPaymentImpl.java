package com.design.strategy.payment;

import java.util.UUID;

class CouponPaymentImpl implements PaymentStrategy {

	private Coupon coupon;

	public CouponPaymentImpl(Coupon coupon) {
		this.coupon = coupon;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== COUPON PAYMENT STARTED =====");

		// Step 1: Coupon Validation
		if (coupon.getCouponCode() == null || coupon.getCouponCode().isEmpty()) {

			System.out.println("Invalid Coupon Code");
			return;
		}

		// Step 2: Coupon Active Validation
		if (!coupon.isActive()) {

			System.out.println("Coupon Is Expired/Blocked");
			return;
		}

		// Step 3: Usage Limit Validation
		if (coupon.getUsageLimit() <= 0) {

			System.out.println("Coupon Usage Limit Exceeded");

			return;
		}

		// Step 4: Minimum Order Validation
		if (amount < coupon.getMinimumOrderAmount()) {

			System.out.println("Minimum order amount should be Rs." + coupon.getMinimumOrderAmount());

			return;
		}

		// Step 5: Discount Calculation
		double calculatedDiscount = amount * coupon.getDiscountPercentage() / 100;

		// Step 6: Max Discount Validation
		double finalDiscount = Math.min(calculatedDiscount, coupon.getMaxDiscountAmount());

		// Step 7: Final Payable Amount
		double finalPayableAmount = amount - finalDiscount;

		// Step 8: Fraud Detection
		boolean fraudDetected = fraudCheck(finalDiscount);

		if (fraudDetected) {

			System.out.println("Fraudulent Coupon Usage Detected");

			return;
		}

		// Step 9: Reduce Usage Count
		coupon.setUsageLimit(coupon.getUsageLimit() - 1);

		// Step 10: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 11: Transaction Logging
		transactionLogging(transactionId, finalDiscount);

		// Step 12: Notification
		sendNotification(finalDiscount);

		// Step 13: Success Response
		System.out.println("\n===== COUPON APPLIED SUCCESSFULLY =====");

		System.out.println("Customer Name : " + coupon.getCustomerName());

		System.out.println("Coupon Code   : " + coupon.getCouponCode());

		System.out.println("Original Amount : " + amount);

		System.out.println("Discount Amount : " + finalDiscount);

		System.out.println("Final Payable Amount : " + finalPayableAmount);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Remaining Coupon Usage : " + coupon.getUsageLimit());
	}

	// Fraud Detection
	private boolean fraudCheck(double discount) {

		System.out.println("Running Coupon Fraud Detection...");

		return discount > 10000;
	}

	// Transaction Logging
	private void transactionLogging(String transactionId, double discount) {

		System.out.println("Transaction Logged Successfully");

		System.out.println("Txn ID : " + transactionId);

		System.out.println("Discount : " + discount);
	}

	// Notification
	private void sendNotification(double discount) {

		System.out.println("Notification Sent:");
		System.out.println("You saved Rs." + discount + " using coupon");
	}
}