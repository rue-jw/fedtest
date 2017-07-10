package com.ruelala.returns.fedex.dto;

public class ItemRequest {
    private Item item;

    public ItemRequest() {
        // Empty constructor
    }
    
    public ItemRequest(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ItemRequest [item=").append(item).append("]");
        return builder.toString();
    }
}
