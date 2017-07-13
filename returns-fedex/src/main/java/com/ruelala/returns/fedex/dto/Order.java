package com.ruelala.returns.fedex.dto;

import java.util.List;

public class Order {
    private String orderNumber;
    private String orderDate;
    private List<Item> items;

    public Order() {
        // Default constructor
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Order [orderNumber=").append(orderNumber).append(", orderDate=").append(orderDate).append(", items=").append(items).append("]");
        return builder.toString();
    }

}
