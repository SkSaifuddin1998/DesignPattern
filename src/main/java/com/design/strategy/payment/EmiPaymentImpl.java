package com.design.strategy.payment;
import java.util.UUID;

class EmiPaymentImpl implements PaymentStrategy {

    private EmiAccount emiAccount;

    public EmiPaymentImpl(EmiAccount emiAccount) {
        this.emiAccount = emiAccount;
    }

    @Override
    public void payment(double amount) {

        System.out.println("\n===== EMI PAYMENT STARTED =====");

        // Step 1: Credit Score Validation
        if (emiAccount.getCreditScore() < 700) {

            System.out.println("Low Credit Score");
            System.out.println("EMI Not Approved");
            return;
        }

        // Step 2: Loan Eligibility Check
        if (amount > emiAccount.getApprovedLoanAmount()) {

            System.out.println("Requested Amount Exceeds Loan Limit");
            return;
        }

        // Step 3: Down Payment Calculation
        double downPayment = amount * 0.10;

        // Step 4: Loan Amount
        double loanAmount = amount - downPayment;

        // Step 5: EMI Calculation
        int tenureMonths = 12;

        double annualInterestRate = 12;

        double monthlyInterest =
                annualInterestRate / (12 * 100);

        double emi =
                (loanAmount * monthlyInterest
                        * Math.pow(1 + monthlyInterest,
                        tenureMonths))
                        /
                        (Math.pow(1 + monthlyInterest,
                                tenureMonths) - 1);

        // Step 6: Bank Approval
        boolean approved = bankApproval();

        if (!approved) {

            System.out.println("Bank Rejected EMI Request");
            return;
        }

        // Step 7: Deduct Approved Loan Amount
        emiAccount.setApprovedLoanAmount(
                emiAccount.getApprovedLoanAmount()
                        - amount);

        // Step 8: Generate Transaction ID
        String transactionId =
                UUID.randomUUID().toString();

        // Step 9: Transaction Logging
        transactionLogging(transactionId, amount);

        // Step 10: Success Response
        System.out.println("\n===== EMI PAYMENT SUCCESS =====");

        System.out.println("Customer Name : "
                + emiAccount.getCustomerName());

        System.out.println("Bank Name     : "
                + emiAccount.getBankName());

        System.out.println("Loan Account  : "
                + emiAccount.getLoanAccountNumber());

        System.out.println("Purchase Amount : "
                + amount);

        System.out.println("Down Payment    : "
                + downPayment);

        System.out.println("Loan Amount     : "
                + loanAmount);

        System.out.println("EMI Tenure      : "
                + tenureMonths + " Months");

        System.out.println("Monthly EMI     : "
                + Math.round(emi));

        System.out.println("Transaction ID  : "
                + transactionId);

        System.out.println("Remaining Loan Eligibility : "
                + emiAccount.getApprovedLoanAmount());
    }

    // Simulate Bank Approval
    private boolean bankApproval() {

        System.out.println("Checking Bank Approval...");
        return true;
    }

    // Transaction Logging
    private void transactionLogging(
            String transactionId,
            double amount) {

        System.out.println("Transaction Logged Successfully");

        System.out.println("Txn ID : "
                + transactionId);

        System.out.println("Amount : "
                + amount);
    }
}