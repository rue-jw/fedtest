package com.ruelala.returns.api.object;

import java.util.List;

public interface ItemData {

    int getItemId();

    void setItemId(int itemId);

    String getSku();

    void setSku(String sku);

    String getUpc();

    void setUpc(String upc);

    String getName();

    void setName(String name);

    int getProductCategory();

    void setProductCategory(int productCategory);

    List<Object> getVariants();

    void setVariants(List<Object> variants);

}