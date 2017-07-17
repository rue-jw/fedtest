package com.ruelala.returns.fedex.dto;

public class ReturnItemInfo {
    private String returnReason;
    private Boolean returnEligibilityOverride;
    private Boolean finalSale;

    public ReturnItemInfo() {
        // Default constructor
    }

    public ReturnItemInfo(String returnReason, Boolean returnEligibilityOverride, Boolean finalSale) {
        super();
        this.returnReason = returnReason;
        this.returnEligibilityOverride = returnEligibilityOverride;
        this.finalSale = finalSale;
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

    public Boolean getFinalSale() {
        return finalSale;
    }

    public void setFinalSale(Boolean finalSale) {
        this.finalSale = finalSale;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReturnItemInfo [returnReason=").append(returnReason).append(", returnEligibilityOverride=").append(returnEligibilityOverride)
                .append(", finalSale=").append(finalSale).append("]");
        return builder.toString();
    }

}
