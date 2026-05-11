package com.design.strategy.payment;
class RewardAccount {

    private String customerName;
    private String membershipId;
    private String membershipType;
    private int rewardPoints;
    private boolean active;

    public RewardAccount(String customerName,
                         String membershipId,
                         String membershipType,
                         int rewardPoints,
                         boolean active) {

        this.customerName = customerName;
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.rewardPoints = rewardPoints;
        this.active = active;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public boolean isActive() {
        return active;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }
}