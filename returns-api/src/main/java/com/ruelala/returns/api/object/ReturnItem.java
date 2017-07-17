package com.ruelala.returns.api.object;

public class ReturnItem {
    private String sku;
    private Integer quantity;
    private String returnReason;
    private Boolean returnEligibilityOverride;
    private Boolean finalSale;

    public ReturnItem() {
    }

    public ReturnItem(String sku, Integer quantity, String returnReason) {
        super();
        this.sku = sku;
        this.quantity = quantity;
        this.returnReason = returnReason;
    }

    public ReturnItem(String sku, Integer quantity, String returnReason, Boolean returnEligibilityOverride, Boolean finalSale, String advanceCreditCode) {
        super();
        this.sku = sku;
        this.quantity = quantity;
        this.returnReason = returnReason;
        this.returnEligibilityOverride = returnEligibilityOverride;
        this.finalSale = finalSale;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        builder.append("ReturnItem [sku=").append(sku).append(", quantity=").append(quantity).append(", returnReason=").append(returnReason)
                .append(", returnEligibilityOverride=").append(returnEligibilityOverride).append(", finalSale=").append(finalSale).append("]");
        return builder.toString();
    }

}
