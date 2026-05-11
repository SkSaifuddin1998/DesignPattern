package com.design.strategy.payment;

class Wallet {

	private String walletId;
	private String customerName;
	private String mobileNumber;
	private String walletPin;
	private double balance;

	public Wallet(String walletId, String customerName, String mobileNumber, String walletPin, double balance) {

		this.walletId = walletId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.walletPin = walletPin;
		this.balance = balance;
	}

	public String getWalletId() {
		return walletId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getWalletPin() {
		return walletPin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}