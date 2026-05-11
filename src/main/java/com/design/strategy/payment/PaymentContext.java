package com.design.strategy.payment;

class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(
            PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {

        paymentStrategy.payment(amount);
    }
}