package com.ruelala.returns.api.object;

import java.math.BigDecimal;

public class ReturnResponse {
    private String rmaId;
    private String rmaNumber;
    private BigDecimal shippingCost;
    private String destinationId;
    private String destinationName;
    private Integer labelId;
    private String trackingNumber;

    public ReturnResponse() {
    }

    public ReturnResponse(String rmaId, String rmaNumber, BigDecimal shippingCost, String destinationId, String destinationName, Integer labelId,
            String trackingNumber) {
        super();
        this.rmaId = rmaId;
        this.rmaNumber = rmaNumber;
        this.shippingCost = shippingCost;
        this.destinationId = destinationId;
        this.destinationName = destinationName;
        this.labelId = labelId;
        this.trackingNumber = trackingNumber;
    }

    public String getRmaId() {
        return rmaId;
    }

    public void setRmaId(String rmaId) {
        this.rmaId = rmaId;
    }

    public String getRmaNumber() {
        return rmaNumber;
    }

    public void setRmaNumber(String rmaNumber) {
        this.rmaNumber = rmaNumber;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReturnResponse [rmaId=").append(rmaId).append(", rmaNumber=").append(rmaNumber).append(", shippingCost=").append(shippingCost)
                .append(", destinationId=").append(destinationId).append(", destinationName=").append(destinationName).append(", labelId=").append(labelId)
                .append(", trackingNumber=").append(trackingNumber).append("]");
        return builder.toString();
    }

}
