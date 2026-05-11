package com.design.strategy.payment;

import java.util.UUID;

class CryptoPaymentImpl implements PaymentStrategy {

	private CryptoWallet wallet;

	public CryptoPaymentImpl(CryptoWallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public void payment(double amount) {

		System.out.println("\n===== CRYPTO PAYMENT STARTED =====");

		// Step 1: Wallet Address Validation
		if (wallet.getWalletAddress() == null || wallet.getWalletAddress().length() < 20) {

			System.out.println("Invalid Wallet Address");
			return;
		}

		// Step 2: Blockchain Network Validation
		if (!validateNetwork(wallet.getNetwork())) {

			System.out.println("Unsupported Blockchain Network");
			return;
		}

		// Step 3: Wallet Authentication
		boolean authenticated = authenticateWallet();

		if (!authenticated) {

			System.out.println("Wallet Authentication Failed");
			return;
		}

		// Step 4: Balance Check
		if (amount > wallet.getCryptoBalance()) {

			System.out.println("Insufficient Crypto Balance");
			return;
		}

		// Step 5: Gas Fee Calculation
		double gasFee = calculateGasFee(amount);

		System.out.println("Gas Fee : " + gasFee);

		double totalDeduction = amount + gasFee;

		// Step 6: Total Balance Validation
		if (totalDeduction > wallet.getCryptoBalance()) {

			System.out.println("Insufficient Balance Including Gas Fee");

			return;
		}

		// Step 7: Blockchain Verification
		boolean blockchainVerified = blockchainVerification();

		if (!blockchainVerified) {

			System.out.println("Blockchain Verification Failed");

			return;
		}

		// Step 8: Deduct Wallet Balance
		wallet.setCryptoBalance(wallet.getCryptoBalance() - totalDeduction);

		// Step 9: Generate Transaction Hash
		String transactionHash = UUID.randomUUID().toString();

		// Step 10: Broadcast Transaction
		broadcastTransaction(transactionHash);

		// Step 11: Transaction Logging
		transactionLogging(transactionHash, amount);

		// Step 12: Success Response
		System.out.println("\n===== CRYPTO PAYMENT SUCCESS =====");

		System.out.println("Customer Name : " + wallet.getCustomerName());

		System.out.println("Crypto Type   : " + wallet.getCryptoType());

		System.out.println("Network       : " + wallet.getNetwork());

		System.out.println("Amount Sent   : " + amount);

		System.out.println("Gas Fee       : " + gasFee);

		System.out.println("Transaction Hash : " + transactionHash);

		System.out.println("Remaining Crypto Balance : " + wallet.getCryptoBalance());
	}

	// Network Validation
	private boolean validateNetwork(String network) {

		System.out.println("Validating Blockchain Network...");

		return network.equalsIgnoreCase("Ethereum") || network.equalsIgnoreCase("Bitcoin")
				|| network.equalsIgnoreCase("Polygon");
	}

	// Wallet Authentication
	private boolean authenticateWallet() {

		System.out.println("Authenticating Wallet...");

		String enteredPassword = "crypto123";

		return enteredPassword.equals(wallet.getWalletPassword());
	}

	// Gas Fee Calculation
	private double calculateGasFee(double amount) {

		return amount * 0.02;
	}

	// Blockchain Verification
	private boolean blockchainVerification() {

		System.out.println("Verifying Blockchain Transaction...");

		return true;
	}

	// Broadcast Transaction
	private void broadcastTransaction(String transactionHash) {

		System.out.println("Broadcasting Transaction To Blockchain...");
		System.out.println("Hash : " + transactionHash);
	}

	// Transaction Logging
	private void transactionLogging(String transactionHash, double amount) {

		System.out.println("Transaction Logged Successfully");

		System.out.println("Txn Hash : " + transactionHash);

		System.out.println("Amount   : " + amount);
	}
}