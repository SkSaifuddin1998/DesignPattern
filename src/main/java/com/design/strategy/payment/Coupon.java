package com.design.strategy.payment;

class Coupon {

	private String couponCode;
	private String customerName;
	private double discountPercentage;
	private double maxDiscountAmount;
	private double minimumOrderAmount;
	private boolean active;
	private int usageLimit;

	public Coupon(String couponCode, String customerName, double discountPercentage, double maxDiscountAmount,
			double minimumOrderAmount, boolean active, int usageLimit) {

		this.couponCode = couponCode;
		this.customerName = customerName;
		this.discountPercentage = discountPercentage;
		this.maxDiscountAmount = maxDiscountAmount;
		this.minimumOrderAmount = minimumOrderAmount;
		this.active = active;
		this.usageLimit = usageLimit;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public double getMaxDiscountAmount() {
		return maxDiscountAmount;
	}

	public double getMinimumOrderAmount() {
		return minimumOrderAmount;
	}

	public boolean isActive() {
		return active;
	}

	public int getUsageLimit() {
		return usageLimit;
	}

	public void setUsageLimit(int usageLimit) {
		this.usageLimit = usageLimit;
	}
}