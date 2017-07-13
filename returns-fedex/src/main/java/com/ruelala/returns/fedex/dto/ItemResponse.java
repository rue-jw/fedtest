package com.ruelala.returns.fedex.dto;

import com.ruelala.returns.fedex.dto.base.BaseResponse;

public class ItemResponse extends BaseResponse {

    private Item item;

    public ItemResponse() {
    }

    public ItemResponse(Item item) {
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
        builder.append("ItemResponse [item=").append(item).append(", requestIdentifier=").append(requestIdentifier).append(", transactionDate=")
                .append(transactionDate).append(", success=").append(success).append(", errors=").append(errors).append("]");
        return builder.toString();
    }

}
