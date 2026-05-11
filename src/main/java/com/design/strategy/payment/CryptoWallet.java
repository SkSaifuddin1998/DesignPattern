package com.design.strategy.payment;
class CryptoWallet {

    private String customerName;
    private String walletAddress;
    private String cryptoType;
    private String network;
    private double cryptoBalance;
    private String walletPassword;

    public CryptoWallet(String customerName,
                        String walletAddress,
                        String cryptoType,
                        String network,
                        double cryptoBalance,
                        String walletPassword) {

        this.customerName = customerName;
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
        this.network = network;
        this.cryptoBalance = cryptoBalance;
        this.walletPassword = walletPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getCryptoType() {
        return cryptoType;
    }

    public String getNetwork() {
        return network;
    }

    public double getCryptoBalance() {
        return cryptoBalance;
    }

    public void setCryptoBalance(double cryptoBalance) {
        this.cryptoBalance = cryptoBalance;
    }

    public String getWalletPassword() {
        return walletPassword;
    }
}