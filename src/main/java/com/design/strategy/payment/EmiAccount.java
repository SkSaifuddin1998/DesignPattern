package com.design.strategy.payment;

class EmiAccount {

	private String customerName;
	private String bankName;
	private String loanAccountNumber;
	private double approvedLoanAmount;
	private int creditScore;

	public EmiAccount(String customerName, String bankName, String loanAccountNumber, double approvedLoanAmount,
			int creditScore) {

		this.customerName = customerName;
		this.bankName = bankName;
		this.loanAccountNumber = loanAccountNumber;
		this.approvedLoanAmount = approvedLoanAmount;
		this.creditScore = creditScore;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getBankName() {
		return bankName;
	}

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public double getApprovedLoanAmount() {
		return approvedLoanAmount;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setApprovedLoanAmount(double approvedLoanAmount) {
		this.approvedLoanAmount = approvedLoanAmount;
	}
}