package com.design.strategy.payment;

class DebitCard {

	private String customerName;
	private String cardNumber;
	private String expiryDate;
	private String cvv;
	private String atmPin;
	private double accountBalance;

	public DebitCard(String customerName, String cardNumber, String expiryDate, String cvv, String atmPin,
			double accountBalance) {

		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.atmPin = atmPin;
		this.accountBalance = accountBalance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public String getAtmPin() {
		return atmPin;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}