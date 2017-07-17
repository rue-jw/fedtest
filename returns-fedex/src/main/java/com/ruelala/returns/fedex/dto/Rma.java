package com.ruelala.returns.fedex.dto;

import java.math.BigDecimal;
import java.util.List;

public class Rma {
    private String rmaId;
    private String rmaNumber;
    private String status;
    private String shippingService;
    private BigDecimal shippingCost;
    // Possible values: 'Consumer', 'Retailer'
    private String shippingCostResponsibility;
    private Customer customer;
    private Boolean labelRequired;
    private Boolean emailNotification;
    private String shipToAddressId;
    private String shipToAddressName;
    private String specialtyFlag;
    private List<Order> orders;
    private Label label;

    public Rma() {
        // Default constructor
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingService() {
        return shippingService;
    }

    public void setShippingService(String shippingService) {
        this.shippingService = shippingService;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getShippingCostResponsibility() {
        return shippingCostResponsibility;
    }

    public void setShippingCostResponsibility(String shippingCostResponsibility) {
        this.shippingCostResponsibility = shippingCostResponsibility;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getLabelRequired() {
        return labelRequired;
    }

    public void setLabelRequired(Boolean labelRequired) {
        this.labelRequired = labelRequired;
    }

    public Boolean getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public String getShipToAddressId() {
        return shipToAddressId;
    }

    public void setShipToAddressId(String shipToAddressId) {
        this.shipToAddressId = shipToAddressId;
    }

    public String getShipToAddressName() {
        return shipToAddressName;
    }

    public void setShipToAddressName(String shipToAddressName) {
        this.shipToAddressName = shipToAddressName;
    }

    public String getSpecialtyFlag() {
        return specialtyFlag;
    }

    public void setSpecialtyFlag(String specialtyFlag) {
        this.specialtyFlag = specialtyFlag;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Rma [rmaId=").append(rmaId).append(", rmaNumber=").append(rmaNumber).append(", status=").append(status).append(", shippingService=")
                .append(shippingService).append(", shippingCost=").append(shippingCost).append(", shippingCostResponsibility=")
                .append(shippingCostResponsibility).append(", customer=").append(customer).append(", labelRequired=").append(labelRequired)
                .append(", emailNotification=").append(emailNotification).append(", shipToAddressId=").append(shipToAddressId).append(", shipToAddressName=")
                .append(shipToAddressName).append(", specialtyFlag=").append(specialtyFlag).append(", orders=").append(orders).append(", label=").append(label)
                .append("]");
        return builder.toString();
    }

}
