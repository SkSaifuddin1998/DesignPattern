package com.design.strategy.payment;

class CreditCard {

	private String cardHolderName;
	private String cardNumber;
	private String expiryDate;
	private String cvv;
	private double availableLimit;

	public CreditCard(String cardHolderName, String cardNumber, String expiryDate, String cvv, double availableLimit) {

		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.availableLimit = availableLimit;
	}

	public String getCardHolderName() {
		return cardHolderName;
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

	public double getAvailableLimit() {
		return availableLimit;
	}

	public void setAvailableLimit(double availableLimit) {
		this.availableLimit = availableLimit;
	}
}