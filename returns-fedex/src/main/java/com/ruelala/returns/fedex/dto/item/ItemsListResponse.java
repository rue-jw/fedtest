package com.ruelala.returns.fedex.dto.item;

import java.util.List;

import com.ruelala.returns.fedex.dto.base.BaseResponse;

public class ItemsListResponse extends BaseResponse {

    private List<Item> items;

    public ItemsListResponse() {
    }

    public ItemsListResponse(List<Item> items) {
        this.items = items;
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
        builder.append("ItemsListResponse [items=").append(items).append(", requestIdentifier=").append(requestIdentifier).append(", transactionDate=")
                .append(transactionDate).append(", success=").append(success).append(", errors=").append(errors).append("]");
        return builder.toString();
    }

}
