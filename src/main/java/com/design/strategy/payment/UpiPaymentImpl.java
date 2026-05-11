package com.design.strategy.payment;

import java.util.UUID;

class UpiPaymentImpl implements PaymentStrategy {

	private UpiAccount upiAccount;

	public UpiPaymentImpl(UpiAccount upiAccount) {
		this.upiAccount = upiAccount;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== UPI PAYMENT STARTED =====");

		// Step 1: UPI ID Validation
		if (upiAccount.getUpiId() == null || !upiAccount.getUpiId().contains("@")) {

			System.out.println("Invalid UPI ID");
			return;
		}

		// Step 2: Mobile Number Validation
		if (upiAccount.getMobileNumber() == null || upiAccount.getMobileNumber().length() != 10) {

			System.out.println("Invalid Mobile Number");
			return;
		}

		// Step 3: UPI PIN Validation
		boolean pinVerified = verifyUpiPin();

		if (!pinVerified) {

			System.out.println("Invalid UPI PIN");
			return;
		}

		// Step 4: Balance Check
		if (amount > upiAccount.getBalance()) {

			System.out.println("Insufficient Balance");
			return;
		}

		// Step 5: Fraud Detection
		boolean fraudDetected = fraudCheck(amount);

		if (fraudDetected) {

			System.out.println("Fraud Transaction Detected");
			return;
		}

		// Step 6: NPCI Communication
		boolean bankResponse = connectToBankServer();

		if (!bankResponse) {

			System.out.println("Bank Server Down");
			return;
		}

		// Step 7: Deduct Balance
		upiAccount.setBalance(upiAccount.getBalance() - amount);

		// Step 8: Generate Transaction ID
		String transactionId = UUID.randomUUID().toString();

		// Step 9: Transaction Logging
		transactionLogging(transactionId, amount);

		// Step 10: Success Response
		System.out.println("\n===== PAYMENT SUCCESS =====");

		System.out.println("Account Holder : " + upiAccount.getAccountHolderName());

		System.out.println("UPI ID         : " + upiAccount.getUpiId());

		System.out.println("Bank Name      : " + upiAccount.getBankName());

		System.out.println("Amount Paid    : " + amount);

		System.out.println("Transaction ID : " + transactionId);

		System.out.println("Available Balance : " + upiAccount.getBalance());
	}

	// UPI PIN Verification
	private boolean verifyUpiPin() {

		System.out.println("Verifying UPI PIN...");

		String enteredPin = "1234";

		return enteredPin.equals(upiAccount.getUpiPin());
	}

	// Fraud Detection
	private boolean fraudCheck(double amount) {

		System.out.println("Running Fraud Detection...");

		return amount > 100000;
	}

	// Simulate Bank/NPCI Connection
	private boolean connectToBankServer() {

		System.out.println("Connecting To NPCI Server...");
		System.out.println("Connecting To Bank Server...");

		return true;
	}

	// Transaction Logging
	private void transactionLogging(String transactionId, double amount) {

		System.out.println("Transaction Logged:");
		System.out.println("TxnId : " + transactionId);
		System.out.println("Amount: " + amount);
	}
}