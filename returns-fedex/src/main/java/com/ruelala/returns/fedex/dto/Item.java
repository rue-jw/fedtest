package com.ruelala.returns.fedex.dto;

import java.util.List;

/**
 * @author jonathan.williams
 *
 */
public class Item {
    private int itemId;
    private String sku;
    private String upc;
    private String name;
    private int productCategory;
    private List<Object> variants;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public List<Object> getVariants() {
        return variants;
    }

    public void setVariants(List<Object> variants) {
        this.variants = variants;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ItemDto [itemId=").append(itemId).append(", sku=").append(sku).append(", upc=").append(upc).append(", name=").append(name)
                .append(", productCategory=").append(productCategory).append(", variants=").append(variants).append("]");
        return builder.toString();
    }
}
