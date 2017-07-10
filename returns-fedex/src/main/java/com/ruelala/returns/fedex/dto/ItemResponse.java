package com.ruelala.returns.fedex.dto;

public class ItemResponse extends BaseResponse {
    
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ItemResponse [item=").append(item).append("]");
        return builder.toString();
    }

}
