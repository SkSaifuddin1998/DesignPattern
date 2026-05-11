package com.design.strategy.payment;
class NetBankingAccount {

    private String customerName;
    private String bankName;
    private String customerId;
    private String loginPassword;
    private double accountBalance;

    public NetBankingAccount(String customerName,
                             String bankName,
                             String customerId,
                             String loginPassword,
                             double accountBalance) {

        this.customerName = customerName;
        this.bankName = bankName;
        this.customerId = customerId;
        this.loginPassword = loginPassword;
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(
            double accountBalance) {

        this.accountBalance = accountBalance;
    }
}