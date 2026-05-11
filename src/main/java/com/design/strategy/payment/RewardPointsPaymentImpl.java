package com.design.strategy.payment;
import java.util.UUID;

class RewardPointsPaymentImpl
        implements PaymentStrategy {

    private RewardAccount rewardAccount;

    public RewardPointsPaymentImpl(
            RewardAccount rewardAccount) {

        this.rewardAccount = rewardAccount;
    }

    @Override
    public void payment(double amount) {

        System.out.println(
                "\n===== REWARD POINTS PAYMENT STARTED =====");

        // Step 1: Membership Validation
        if (rewardAccount.getMembershipId() == null
                || rewardAccount.getMembershipId().isEmpty()) {

            System.out.println("Invalid Membership ID");
            return;
        }

        // Step 2: Membership Active Check
        if (!rewardAccount.isActive()) {

            System.out.println("Membership Is Inactive");
            return;
        }

        // Step 3: Minimum Redemption Validation
        if (amount < 100) {

            System.out.println(
                    "Minimum redemption amount is Rs.100");

            return;
        }

        // Step 4: Convert Amount to Reward Points
        // Example:
        // 1 Point = Rs.1

        int requiredPoints = (int) amount;

        System.out.println(
                "Required Reward Points : "
                        + requiredPoints);

        // Step 5: Reward Balance Check
        if (requiredPoints
                > rewardAccount.getRewardPoints()) {

            System.out.println(
                    "Insufficient Reward Points");

            return;
        }

        // Step 6: Fraud Detection
        boolean fraudDetected =
                fraudCheck(requiredPoints);

        if (fraudDetected) {

            System.out.println(
                    "Fraudulent Reward Redemption Detected");

            return;
        }

        // Step 7: Deduct Reward Points
        rewardAccount.setRewardPoints(
                rewardAccount.getRewardPoints()
                        - requiredPoints);

        // Step 8: Generate Transaction ID
        String transactionId =
                UUID.randomUUID().toString();

        // Step 9: Transaction Logging
        transactionLogging(transactionId,
                requiredPoints);

        // Step 10: Notification Trigger
        sendNotification(requiredPoints);

        // Step 11: Success Response
        System.out.println(
                "\n===== REWARD PAYMENT SUCCESS =====");

        System.out.println("Customer Name : "
                + rewardAccount.getCustomerName());

        System.out.println("Membership ID : "
                + rewardAccount.getMembershipId());

        System.out.println("Membership Type : "
                + rewardAccount.getMembershipType());

        System.out.println("Redeemed Amount : "
                + amount);

        System.out.println("Reward Points Used : "
                + requiredPoints);

        System.out.println("TransactionId : "
                + transactionId);

        System.out.println("Remaining Reward Points : "
                + rewardAccount.getRewardPoints());
    }

    // Fraud Detection
    private boolean fraudCheck(int points) {

        System.out.println(
                "Running Reward Fraud Detection...");

        return points > 50000;
    }

    // Transaction Logging
    private void transactionLogging(
            String transactionId,
            int points) {

        System.out.println(
                "Transaction Logged Successfully");

        System.out.println("Txn ID : "
                + transactionId);

        System.out.println("Points : "
                + points);
    }

    // Notification
    private void sendNotification(int points) {

        System.out.println("Notification Sent:");
        System.out.println(points
                + " reward points redeemed successfully");
    }
}