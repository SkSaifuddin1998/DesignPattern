package com.design.strategy.payment;

import java.util.UUID;

class CashbackPaymentImpl implements PaymentStrategy {

	private CashbackAccount cashbackAccount;

	public CashbackPaymentImpl(CashbackAccount cashbackAccount) {

		this.cashbackAccount = cashbackAccount;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== CASHBACK PAYMENT STARTED =====");

		// Step 1: Customer Validation
		if (cashbackAccount.getCustomerId() == null || cashbackAccount.getCustomerId().isEmpty()) {

			System.out.println("Invalid Customer ID");
			return;
		}

		// Step 2: Account Active Validation
		if (!cashbackAccount.isActive()) {

			System.out.println("Cashback Account Is Inactive");

			return;
		}

		// Step 3: Minimum Transaction Validation
		if (amount < 500) {

			System.out.println("Cashback applicable only for transactions above Rs.500");

			return;
		}

		// Step 4: Cashback Percentage
		double cashbackPercentage = 10;

		// Step 5: Cashback Calculation
		double calculatedCashback = amount * cashbackPercentage / 100;

		// Step 6: Maximum Cashback Validation
		double maxCashback = 1000;

		double finalCashback = Math.min(calculatedCashback, maxCashback);

		// Step 7: Fraud Detection
		boolean fraudDetected = fraudCheck(finalCashback);

		if (fraudDetected) {

			System.out.println("Fraudulent Cashback Activity Detected");

			return;
		}

		// Step 8: Credit Cashback Wallet
		cashbackAccount.setCashbackBalance(cashbackAccount.getCashbackBalance() + finalCashback);

		// Step 9: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 10: Transaction Logging
		transactionLogging(transactionId, finalCashback);

		// Step 11: Notification
		sendNotification(finalCashback);

		// Step 12: Success Response
		System.out.println("\n===== CASHBACK CREDITED SUCCESSFULLY =====");

		System.out.println("Customer Name : " + cashbackAccount.getCustomerName());

		System.out.println("Customer ID   : " + cashbackAccount.getCustomerId());

		System.out.println("Order Amount  : " + amount);

		System.out.println("Cashback Percentage : " + cashbackPercentage + "%");

		System.out.println("Cashback Earned : " + finalCashback);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Updated Cashback Balance : " + cashbackAccount.getCashbackBalance());
	}

	// Fraud Detection
	private boolean fraudCheck(double cashback) {

		System.out.println("Running Cashback Fraud Detection...");

		return cashback > 5000;
	}

	// Transaction Logging
	private void transactionLogging(String transactionId, double cashback) {

		System.out.println("Transaction Logged Successfully");

		System.out.println("Txn ID : " + transactionId);

		System.out.println("Cashback : " + cashback);
	}

	// Notification
	private void sendNotification(double cashback) {

		System.out.println("Notification Sent:");

		System.out.println("Rs." + cashback + " cashback credited successfully");
	}
}