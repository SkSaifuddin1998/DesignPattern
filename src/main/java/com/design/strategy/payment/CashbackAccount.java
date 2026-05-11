package com.design.strategy.payment;
class CashbackAccount {

    private String customerName;
    private String customerId;
    private String cashbackWalletId;
    private double cashbackBalance;
    private boolean active;

    public CashbackAccount(String customerName,
                           String customerId,
                           String cashbackWalletId,
                           double cashbackBalance,
                           boolean active) {

        this.customerName = customerName;
        this.customerId = customerId;
        this.cashbackWalletId = cashbackWalletId;
        this.cashbackBalance = cashbackBalance;
        this.active = active;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCashbackWalletId() {
        return cashbackWalletId;
    }

    public double getCashbackBalance() {
        return cashbackBalance;
    }

    public boolean isActive() {
        return active;
    }

    public void setCashbackBalance(double cashbackBalance) {
        this.cashbackBalance = cashbackBalance;
    }
}