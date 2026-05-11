package com.design.strategy.payment;
class GiftCard {

    private String giftCardNumber;
    private String customerName;
    private String expiryDate;
    private String giftPin;
    private boolean active;
    private double availableBalance;

    public GiftCard(String giftCardNumber,
                    String customerName,
                    String expiryDate,
                    String giftPin,
                    boolean active,
                    double availableBalance) {

        this.giftCardNumber = giftCardNumber;
        this.customerName = customerName;
        this.expiryDate = expiryDate;
        this.giftPin = giftPin;
        this.active = active;
        this.availableBalance = availableBalance;
    }

    public String getGiftCardNumber() {
        return giftCardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getGiftPin() {
        return giftPin;
    }

    public boolean isActive() {
        return active;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
}