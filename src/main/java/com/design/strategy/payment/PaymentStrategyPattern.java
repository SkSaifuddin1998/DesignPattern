package com.design.strategy.payment;

import java.util.Scanner;

class PaymentStrategyPattern {

	public static void main(String[] args) {
		// EMI=P×R×(1+R)^N/(1+R)^N−1​

		Scanner sc = new Scanner(System.in);

		// Credit Card Object
		CreditCard card = new CreditCard("Saifuddin", "1234567812345678", "12/30", "123", 50000);

		// UPI Object
		UpiAccount account = new UpiAccount("Saifuddin", "sujan@oksbi", "State Bank Of India", "9876543210", "1234",
				50000);

		Wallet wallet = new Wallet("WALLET1001", "Saifuddin", "9876543210", "4321", 30000);

		EmiAccount emiAccount = new EmiAccount("Sujan", "HDFC Bank", "LN00998877", 500000, 750);

		DebitCard debitCard = new DebitCard("Sujan", "9876543212345678", "11/29", "456", "5678", 80000);

		CryptoWallet cryptoWallet = new CryptoWallet("Sujan", "0xA1B2C3D4E5F6G7H8I9J0", "Ethereum", "Ethereum", 10.5,
				"crypto123");

		GiftCard giftCard = new GiftCard("9876543212345678", "Sujan", "12/28", "9999", true, 30000);

		RewardAccount rewardAccount = new RewardAccount("Sujan", "MEM1001", "GOLD", 20000, true);

		Coupon coupon = new Coupon("SAVE50", "Sujan", 20, 500, 1000, true, 5);

		CashbackAccount cashbackAccount = new CashbackAccount("Sujan", "CUS1001", "CBWALLET001", 2500, true);
		PayPalAccount payPalAccount = new PayPalAccount("Sujan", "sujan@gmail.com", "paypal123", 80000, true);
		NetBankingAccount netAccount = new NetBankingAccount("Sujan", "HDFC Bank", "CUS7788", "net123", 150000);

		PaymentContext paymentContext = new PaymentContext();

		System.out.println("===== SELECT PAYMENT METHOD =====");
		System.out.println("1. Credit Card");
		System.out.println("2. UPI");
		System.out.println("3. Wallet");
		System.out.println("4. EMI");
		System.out.println("5. Debit Card");
		System.out.println("6. Crypto Wallet");
		System.out.println("7. Gift Card ");
		System.out.println("8. Rewards Point ");
		System.out.println("9. Coupon");
		System.out.println("10. Cashback");
		System.out.println("11. Paypal");
		System.out.println("12. NetBanking");

		int choice = sc.nextInt();

		System.out.println("Enter Amount:");
		double amount = sc.nextDouble();

		switch (choice) {

		case 1:

			paymentContext.setPaymentStrategy(new CreditCardImpl(card));

			break;

		case 2:

			paymentContext.setPaymentStrategy(new UpiPaymentImpl(account));

			break;
		case 3:

			paymentContext.setPaymentStrategy(new WalletPaymentImpl(wallet));
			break;

		case 4:

			paymentContext.setPaymentStrategy(new EmiPaymentImpl(emiAccount));
			break;
		case 5:

			paymentContext.setPaymentStrategy(new DebitCardPaymentImpl(debitCard));

			break;
		case 6:

			paymentContext.setPaymentStrategy(new CryptoPaymentImpl(cryptoWallet));

			break;
		case 7:

			paymentContext.setPaymentStrategy(new GiftCardPaymentImpl(giftCard));

			break;

		case 8:

			paymentContext.setPaymentStrategy(new RewardPointsPaymentImpl(rewardAccount));

			break;

		case 9:

			paymentContext.setPaymentStrategy(new CouponPaymentImpl(coupon));

			break;

		case 10:

			paymentContext.setPaymentStrategy(new CashbackPaymentImpl(cashbackAccount));

			break;

		case 11:

			paymentContext.setPaymentStrategy(new PayPalPaymentImpl(payPalAccount));

			break;

		case 12:

			paymentContext.setPaymentStrategy(new NetBankingPaymentImpl(netAccount));

			break;
		default:

			System.out.println("Invalid Payment Option");
			return;
		}

		paymentContext.makePayment(amount);
	}
}
