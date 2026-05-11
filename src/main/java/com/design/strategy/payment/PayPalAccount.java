package com.design.strategy.payment;
class PayPalAccount {

    private String customerName;
    private String email;
    private String password;
    private double balance;
    private boolean active;

    public PayPalAccount(String customerName,
                         String email,
                         String password,
                         double balance,
                         boolean active) {

        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.active = active;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}