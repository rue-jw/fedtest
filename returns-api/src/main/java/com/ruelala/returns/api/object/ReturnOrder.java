package com.ruelala.returns.api.object;

import java.util.List;

public class ReturnOrder {
    private String orderNumber;
    private String orderDate;
    private List<ReturnItem> items;

    public ReturnOrder() {
    }

    public ReturnOrder(String orderNumber, String orderDate, List<ReturnItem> items) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.items = items;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<ReturnItem> getItems() {
        return items;
    }

    public void setItems(List<ReturnItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReturnOrder [orderNumber=").append(orderNumber).append(", orderDate=").append(orderDate).append(", items=").append(items).append("]");
        return builder.toString();
    }

}
