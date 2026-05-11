package com.design.strategy.payment;

import java.util.UUID;

class DebitCardPaymentImpl implements PaymentStrategy {

	private DebitCard debitCard;

	public DebitCardPaymentImpl(DebitCard debitCard) {
		this.debitCard = debitCard;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== DEBIT CARD PAYMENT STARTED =====");

		// Step 1: Card Validation
		if (debitCard.getCardNumber() == null || debitCard.getCardNumber().length() != 16) {

			System.out.println("Invalid Debit Card Number");
			return;
		}

		// Step 2: CVV Validation
		if (debitCard.getCvv() == null || debitCard.getCvv().length() != 3) {

			System.out.println("Invalid CVV");
			return;
		}

		// Step 3: Expiry Validation
		if (debitCard.getExpiryDate() == null || debitCard.getExpiryDate().isEmpty()) {

			System.out.println("Card Expired");
			return;
		}

		// Step 4: ATM PIN Verification
		boolean pinVerified = verifyAtmPin();

		if (!pinVerified) {

			System.out.println("Invalid ATM PIN");
			return;
		}

		// Step 5: Balance Check
		if (amount > debitCard.getAccountBalance()) {

			System.out.println("Insufficient Account Balance");
			return;
		}

		// Step 6: Fraud Detection
		boolean fraudDetected = fraudCheck(amount);

		if (fraudDetected) {

			System.out.println("Fraudulent Transaction Blocked");
			return;
		}

		// Step 7: Bank Authorization
		boolean authorized = bankAuthorization();

		if (!authorized) {

			System.out.println("Bank Authorization Failed");
			return;
		}

		// Step 8: Deduct Account Balance
		debitCard.setAccountBalance(debitCard.getAccountBalance() - amount);

		// Step 9: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 10: Transaction Logging
		transactionLogging(transactionId, amount);

		// Step 11: Send Notification
		sendSmsNotification(amount);

		// Step 12: Success Response
		System.out.println("\n===== PAYMENT SUCCESS =====");

		System.out.println("Customer Name : " + debitCard.getCustomerName());

		System.out.println("Debit Card    : XXXX-XXXX-XXXX-" + debitCard.getCardNumber().substring(12));

		System.out.println("Amount Paid   : " + amount);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Remaining Balance : " + debitCard.getAccountBalance());
	}

	// ATM PIN Verification
	private boolean verifyAtmPin() {

		System.out.println("Verifying ATM PIN...");

		String enteredPin = "5678";

		return enteredPin.equals(debitCard.getAtmPin());
	}

	// Fraud Detection
	private boolean fraudCheck(double amount) {

		System.out.println("Running Fraud Detection...");

		return amount > 200000;
	}

	// Bank Authorization
	private boolean bankAuthorization() {

		System.out.println("Connecting To Bank Server...");
		System.out.println("Authorizing Debit Transaction...");

		return true;
	}

	// Transaction Logging
	private void transactionLogging(String transactionId, double amount) {

		System.out.println("Transaction Logged Successfully");

		System.out.println("Txn ID : " + transactionId);
		System.out.println("Amount : " + amount);
	}

	// SMS Notification
	private void sendSmsNotification(double amount) {

		System.out.println("SMS ALERT:");
		System.out.println("Rs." + amount + " debited from your account");
	}
}