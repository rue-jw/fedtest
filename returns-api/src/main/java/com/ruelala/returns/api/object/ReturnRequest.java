package com.ruelala.returns.api.object;

import java.util.List;

public class ReturnRequest {
    private String rmaNumber;
    private ReturnAddress address;
    // Possible values: 'Consumer', 'Retailer'
    private String shippingCostResponsibility;
    private String vendorId;
    // Possible values: 'AC', 'DNC', 'GR', and null
    private String advanceCreditCode;
    private List<ReturnOrder> orders;

    public ReturnRequest() {
    }

    public ReturnRequest(String rmaNumber, ReturnAddress address, String shippingCostResponsibility, String vendorId, String advanceCreditCode,
            List<ReturnOrder> orders) {
        super();
        this.rmaNumber = rmaNumber;
        this.address = address;
        this.shippingCostResponsibility = shippingCostResponsibility;
        this.vendorId = vendorId;
        this.advanceCreditCode = advanceCreditCode;
        this.orders = orders;
    }

    public String getRmaNumber() {
        return rmaNumber;
    }

    public void setRmaNumber(String rmaNumber) {
        this.rmaNumber = rmaNumber;
    }

    public ReturnAddress getAddress() {
        return address;
    }

    public void setAddress(ReturnAddress address) {
        this.address = address;
    }

    public String getShippingCostResponsibility() {
        return shippingCostResponsibility;
    }

    public void setShippingCostResponsibility(String shippingCostResponsibility) {
        this.shippingCostResponsibility = shippingCostResponsibility;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getAdvanceCreditCode() {
        return advanceCreditCode;
    }

    public void setAdvanceCreditCode(String advanceCreditCode) {
        this.advanceCreditCode = advanceCreditCode;
    }

    public List<ReturnOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ReturnOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReturnRequest [rmaNumber=").append(rmaNumber).append(", address=").append(address).append(", shippingCostResponsibility=")
                .append(shippingCostResponsibility).append(", vendorId=").append(vendorId).append(", advanceCreditCode=").append(advanceCreditCode)
                .append(", orders=").append(orders).append("]");
        return builder.toString();
    }

}
