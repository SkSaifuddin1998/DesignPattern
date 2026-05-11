package com.design.strategy.payment;

import java.util.UUID;

class NetBankingPaymentImpl implements PaymentStrategy {

	private NetBankingAccount account;

	public NetBankingPaymentImpl(NetBankingAccount account) {

		this.account = account;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== NET BANKING PAYMENT STARTED =====");

		// Step 1: Customer Validation
		if (account.getCustomerId() == null || account.getCustomerId().isEmpty()) {

			System.out.println("Invalid Customer ID");

			return;
		}

		// Step 2: Password Authentication
		boolean authenticated = authenticate();

		if (!authenticated) {

			System.out.println("Invalid Net Banking Password");

			return;
		}

		// Step 3: OTP Verification
		boolean otpVerified = verifyOtp();

		if (!otpVerified) {

			System.out.println("Invalid OTP");

			return;
		}

		// Step 4: Balance Check
		if (amount > account.getAccountBalance()) {

			System.out.println("Insufficient Balance");

			return;
		}

		// Step 5: Fraud Detection
		boolean fraudDetected = fraudCheck(amount);

		if (fraudDetected) {

			System.out.println("Fraudulent Net Banking Transaction");

			return;
		}

		// Step 6: Bank Authorization
		boolean authorized = bankAuthorization();

		if (!authorized) {

			System.out.println("Bank Authorization Failed");

			return;
		}

		// Step 7: Deduct Balance
		account.setAccountBalance(account.getAccountBalance() - amount);

		// Step 8: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 9: Transaction Logging
		transactionLogging(transactionId, amount);

		// Step 10: Notification
		sendNotification(amount);

		// Step 11: Success Response
		System.out.println("\n===== NET BANKING PAYMENT SUCCESS =====");

		System.out.println("Customer Name : " + account.getCustomerName());

		System.out.println("Bank Name     : " + account.getBankName());

		System.out.println("Amount Paid   : " + amount);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Remaining Balance : " + account.getAccountBalance());
	}

	private boolean authenticate() {

		System.out.println("Authenticating Net Banking User...");

		String enteredPassword = "net123";

		return enteredPassword.equals(account.getLoginPassword());
	}

	private boolean verifyOtp() {

		System.out.println("Verifying OTP...");

		int enteredOtp = 123456;

		return enteredOtp == 123456;
	}

	private boolean fraudCheck(double amount) {

		System.out.println("Running Fraud Detection...");

		return amount > 500000;
	}

	private boolean bankAuthorization() {

		System.out.println("Connecting To Bank Server...");

		return true;
	}

	private void transactionLogging(String transactionId, double amount) {

		System.out.println("Transaction Logged Successfully");

		System.out.println("Txn ID : " + transactionId);

		System.out.println("Amount : " + amount);
	}

	private void sendNotification(double amount) {

		System.out.println("SMS/Email Notification Sent");

		System.out.println("Rs." + amount + " transferred successfully");
	}
}