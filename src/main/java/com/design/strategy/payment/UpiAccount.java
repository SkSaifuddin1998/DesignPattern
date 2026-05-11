package com.design.strategy.payment;

class UpiAccount {

	private String accountHolderName;
	private String upiId;
	private String bankName;
	private String mobileNumber;
	private String upiPin;
	private double balance;

	public UpiAccount(String accountHolderName, String upiId, String bankName, String mobileNumber, String upiPin,
			double balance) {

		this.accountHolderName = accountHolderName;
		this.upiId = upiId;
		this.bankName = bankName;
		this.mobileNumber = mobileNumber;
		this.upiPin = upiPin;
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getUpiId() {
		return upiId;
	}

	public String getBankName() {
		return bankName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getUpiPin() {
		return upiPin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}