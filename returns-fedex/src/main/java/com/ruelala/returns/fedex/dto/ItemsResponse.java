package com.ruelala.returns.fedex.dto;

import java.util.List;

public class ItemsResponse extends BaseResponse {
    
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ItemsResponse [items=").append(items).append("]");
        return builder.toString();
    }

}
