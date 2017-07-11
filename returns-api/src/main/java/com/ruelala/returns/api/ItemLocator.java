package com.ruelala.returns.api;

import com.ruelala.returns.api.object.ItemData;

public interface ItemLocator {
    
    public ItemData findItem(String sku);
}
