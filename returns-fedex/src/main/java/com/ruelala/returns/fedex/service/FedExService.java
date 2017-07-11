package com.ruelala.returns.fedex.service;

import org.springframework.stereotype.Service;

import com.ruelala.returns.fedex.api.ItemsApi;
import com.ruelala.returns.fedex.dto.item.Item;
import com.ruelala.returns.fedex.dto.item.ItemRequest;
import com.ruelala.returns.fedex.dto.item.ItemResponse;
import com.ruelala.returns.fedex.dto.item.ItemsListResponse;

@Service
public class FedExService {

    private final ItemsApi itemsApi;
    
    public FedExService(FedExApiFactory factory) {
        super();
        
        itemsApi = factory.buildItemsApi();
    }

    public Item findItem(String sku) {
        final ItemsListResponse response = itemsApi.findItem(sku);
        
        return response.getItems().get(0);
    }

    public Boolean createItem(Item item) {
        final ItemRequest request = new ItemRequest(item);
        final ItemResponse response = itemsApi.createItem(request);
        
        return response.isSuccess();
    }

    public Boolean updateItem(Item item) {
        final ItemRequest request = new ItemRequest(item);
        final ItemResponse response = itemsApi.updateItem(request);
        
        return response.isSuccess();
    }

}
