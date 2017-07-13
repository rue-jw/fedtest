package com.ruelala.returns.fedex.dto;

public class ReturnItemInfo {
    private String returnReason;
    private Boolean returnEligibilityOverride;

    public ReturnItemInfo() {
        // Default constructor
    }

    public ReturnItemInfo(String returnReason, Boolean returnEligibilityOverride) {
        this.returnReason = returnReason;
        this.returnEligibilityOverride = returnEligibilityOverride;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public Boolean getReturnEligibilityOverride() {
        return returnEligibilityOverride;
    }

    public void setReturnEligibilityOverride(Boolean returnEligibilityOverride) {
        this.returnEligibilityOverride = returnEligibilityOverride;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReturnItemInfo [returnReason=").append(returnReason).append(", returnEligibilityOverride=").append(returnEligibilityOverride)
                .append("]");
        return builder.toString();
    }
}
