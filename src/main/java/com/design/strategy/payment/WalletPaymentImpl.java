package com.design.strategy.payment;

import java.util.UUID;

class WalletPaymentImpl implements PaymentStrategy {

	private Wallet wallet;

	public WalletPaymentImpl(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== WALLET PAYMENT STARTED =====");

		// Step 1: Wallet Validation
		if (wallet.getWalletId() == null || wallet.getWalletId().isEmpty()) {

			System.out.println("Invalid Wallet ID");
			return;
		}

		// Step 2: Mobile Validation
		if (wallet.getMobileNumber() == null || wallet.getMobileNumber().length() != 10) {

			System.out.println("Invalid Mobile Number");
			return;
		}

		// Step 3: Wallet PIN Verification
		boolean pinVerified = verifyWalletPin();

		if (!pinVerified) {

			System.out.println("Invalid Wallet PIN");
			return;
		}

		// Step 4: Balance Check
		if (amount > wallet.getBalance()) {

			System.out.println("Insufficient Wallet Balance");
			return;
		}

		// Step 5: Fraud Detection
		boolean fraudDetected = fraudCheck(amount);

		if (fraudDetected) {

			System.out.println("Fraudulent Transaction Blocked");
			return;
		}

		// Step 6: Deduct Wallet Balance
		wallet.setBalance(wallet.getBalance() - amount);

		// Step 7: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 8: Transaction Logging
		transactionLogging(transactionId, amount);

		// Step 9: Success Response
		System.out.println("\n===== WALLET PAYMENT SUCCESS =====");

		System.out.println("Customer Name : " + wallet.getCustomerName());

		System.out.println("Wallet ID     : " + wallet.getWalletId());

		System.out.println("Amount Paid   : " + amount);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Remaining Balance : " + wallet.getBalance());
	}

	// Wallet PIN Verification
	private boolean verifyWalletPin() {

		System.out.println("Verifying Wallet PIN...");

		String enteredPin = "4321";

		return enteredPin.equals(wallet.getWalletPin());
	}

	// Fraud Detection
	private boolean fraudCheck(double amount) {

		System.out.println("Checking Fraud Detection...");

		return amount > 50000;
	}

	// Transaction Logging
	private void transactionLogging(String transactionId, double amount) {

		System.out.println("Transaction Logged Successfully");
		System.out.println("Txn ID : " + transactionId);
		System.out.println("Amount : " + amount);
	}
}