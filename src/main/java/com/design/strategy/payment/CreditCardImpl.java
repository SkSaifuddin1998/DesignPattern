package com.design.strategy.payment;

import java.util.UUID;

class CreditCardImpl implements PaymentStrategy {

	private CreditCard card;

	public CreditCardImpl(CreditCard card) {
		this.card = card;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== CREDIT CARD PAYMENT STARTED =====");

		if (card.getCardNumber() == null || card.getCardNumber().length() != 16) {

			System.out.println("Invalid Card Number");
			return;
		}

		// Step 2: CVV Validation
		if (card.getCvv() == null || card.getCvv().length() != 3) {

			System.out.println("Invalid CVV");
			return;
		}

		// Step 3: Expiry Validation
		if (card.getExpiryDate() == null || card.getExpiryDate().isEmpty()) {

			System.out.println("Card Expired");
			return;
		}

		// Step 4: Balance Check
		if (amount > card.getAvailableLimit()) {

			System.out.println("Insufficient Credit Limit");
			return;
		}

		// Step 5: OTP Verification
		boolean otpVerified = verifyOtp();

		if (!otpVerified) {

			System.out.println("OTP Verification Failed");
			return;
		}

		// Step 6: Deduct Balance
		card.setAvailableLimit(card.getAvailableLimit() - amount);

		// Step 7: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 8: Success Response
		System.out.println("Card Holder   : " + card.getCardHolderName());

		System.out.println("Card Number   : XXXX-XXXX-XXXX-" + card.getCardNumber().substring(12));

		System.out.println("Amount Paid   : " + amount);

		System.out.println("TransactionId : " + transactionId);

		System.out.println("Available Limit : " + card.getAvailableLimit());

		System.out.println("Payment Successful");
	}

	// OTP Verification Simulation
	private boolean verifyOtp() {

		System.out.println("Verifying OTP...");

		String systemOtp = "1234";
		String userOtp = "1234";

		return systemOtp.equals(userOtp);
	}
}