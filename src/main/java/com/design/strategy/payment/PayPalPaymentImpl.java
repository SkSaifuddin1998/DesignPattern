package com.design.strategy.payment;
import java.util.UUID;

class PayPalPaymentImpl
        implements PaymentStrategy {

    private PayPalAccount account;

    public PayPalPaymentImpl(
            PayPalAccount account) {

        this.account = account;
    }

    @Override
    public void payment(double amount) {

        System.out.println(
                "\n===== PAYPAL PAYMENT STARTED =====");

        // Step 1: Email Validation
        if (account.getEmail() == null
                || !account.getEmail().contains("@")) {

            System.out.println("Invalid Email");
            return;
        }

        // Step 2: Account Active Check
        if (!account.isActive()) {

            System.out.println(
                    "PayPal Account Is Inactive");

            return;
        }

        // Step 3: Authentication
        boolean authenticated =
                authenticate();

        if (!authenticated) {

            System.out.println(
                    "Invalid PayPal Credentials");

            return;
        }

        // Step 4: Balance Check
        if (amount > account.getBalance()) {

            System.out.println(
                    "Insufficient PayPal Balance");

            return;
        }

        // Step 5: Fraud Detection
        boolean fraudDetected =
                fraudCheck(amount);

        if (fraudDetected) {

            System.out.println(
                    "Fraudulent PayPal Transaction");

            return;
        }

        // Step 6: PayPal Authorization
        boolean authorized =
                paypalAuthorization();

        if (!authorized) {

            System.out.println(
                    "PayPal Authorization Failed");

            return;
        }

        // Step 7: Deduct Balance
        account.setBalance(
                account.getBalance() - amount);

        // Step 8: Generate Transaction ID
        String transactionId =
                UUID.randomUUID().toString();

        // Step 9: Transaction Logging
        transactionLogging(transactionId,
                amount);

        // Step 10: Notification
        sendEmailNotification(amount);

        // Step 11: Success Response
        System.out.println(
                "\n===== PAYPAL PAYMENT SUCCESS =====");

        System.out.println("Customer Name : "
                + account.getCustomerName());

        System.out.println("PayPal Email  : "
                + account.getEmail());

        System.out.println("Amount Paid   : "
                + amount);

        System.out.println("TransactionId : "
                + transactionId);

        System.out.println("Remaining Balance : "
                + account.getBalance());
    }

    private boolean authenticate() {

        System.out.println(
                "Authenticating PayPal Account...");

        String enteredPassword = "paypal123";

        return enteredPassword.equals(
                account.getPassword());
    }

    private boolean fraudCheck(double amount) {

        System.out.println(
                "Running PayPal Fraud Detection...");

        return amount > 100000;
    }

    private boolean paypalAuthorization() {

        System.out.println(
                "Connecting To PayPal Server...");

        return true;
    }

    private void transactionLogging(
            String transactionId,
            double amount) {

        System.out.println(
                "Transaction Logged Successfully");

        System.out.println("Txn ID : "
                + transactionId);

        System.out.println("Amount : "
                + amount);
    }

    private void sendEmailNotification(
            double amount) {

        System.out.println(
                "Email Notification Sent");

        System.out.println(
                "Rs." + amount
                        + " paid successfully");
    }
}