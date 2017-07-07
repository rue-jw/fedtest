package com.ruelala.returns.api;

import com.ruelala.returns.api.object.Item;

public interface Returns {
    
    public Item findItem(String sku);
    public Boolean createItem(Item item);
    public Boolean updateItem(Item item);
    
}
