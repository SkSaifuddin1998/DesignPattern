package com.design.strategy.payment;

import java.util.UUID;

class GiftCardPaymentImpl implements PaymentStrategy {

	private GiftCard giftCard;

	public GiftCardPaymentImpl(GiftCard giftCard) {
		this.giftCard = giftCard;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== GIFT CARD PAYMENT STARTED =====");

		// Step 1: Gift Card Validation
		if (giftCard.getGiftCardNumber() == null || giftCard.getGiftCardNumber().length() != 16) {

			System.out.println("Invalid Gift Card Number");
			return;
		}

		// Step 2: Card Active Check
		if (!giftCard.isActive()) {

			System.out.println("Gift Card Is Blocked/Inactive");
			return;
		}

		// Step 3: Expiry Validation
		if (giftCard.getExpiryDate() == null || giftCard.getExpiryDate().isEmpty()) {

			System.out.println("Gift Card Expired");
			return;
		}

		// Step 4: PIN Verification
		boolean pinVerified = verifyGiftPin();

		if (!pinVerified) {

			System.out.println("Invalid Gift Card PIN");
			return;
		}

		// Step 5: Balance Check
		if (amount > giftCard.getAvailableBalance()) {

			System.out.println("Insufficient Gift Card Balance");
			return;
		}

		// Step 6: Fraud Detection
		boolean fraudDetected = fraudCheck(amount);

		if (fraudDetected) {

			System.out.println("Fraudulent Gift Card Usage Detected");
			return;
		}

		// Step 7: Deduct Gift Card Balance
		giftCard.setAvailableBalance(giftCard.getAvailableBalance() - amount);

		// Step 8: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 9: Transaction Logging
		transactionLogging(transactionId, amount);

		// Step 10: Notification Trigger
		sendNotification(amount);

		// Step 11: Success Response
		System.out.println("\n===== GIFT CARD PAYMENT SUCCESS =====");

		System.out.println("Customer Name : " + giftCard.getCustomerName());

		System.out.println("Gift Card     : XXXX-XXXX-XXXX-" + giftCard.getGiftCardNumber().substring(12));

		System.out.println("Amount Used   : " + amount);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Remaining Balance : " + giftCard.getAvailableBalance());
	}

	// PIN Verification
	private boolean verifyGiftPin() {

		System.out.println("Verifying Gift Card PIN...");

		String enteredPin = "9999";

		return enteredPin.equals(giftCard.getGiftPin());
	}

	// Fraud Detection
	private boolean fraudCheck(double amount) {

		System.out.println("Checking Fraud Detection...");

		return amount > 25000;
	}

	// Transaction Logging
	private void transactionLogging(String transactionId, double amount) {

		System.out.println("Transaction Logged Successfully");

		System.out.println("Txn ID : " + transactionId);

		System.out.println("Amount : " + amount);
	}

	// Notification Trigger
	private void sendNotification(double amount) {

		System.out.println("Notification Sent:");
		System.out.println("Gift Card used for Rs." + amount);
	}
}