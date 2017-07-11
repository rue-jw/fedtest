package com.ruelala.returns.fedex.api;

import com.ruelala.returns.fedex.dto.item.ItemRequest;
import com.ruelala.returns.fedex.dto.item.ItemResponse;
import com.ruelala.returns.fedex.dto.item.ItemsListResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(value={"Accept: application/json"})
public interface ItemsApi {

    @RequestLine("GET ?responseFilter=SUMMARY&sku={sku}")
    public ItemsListResponse findItem(@Param("sku") String sku);

    @RequestLine("GET ?responseFilter=DETAIL&sku={sku}")
    public ItemsListResponse findItemDetails(@Param("sku") String sku);
    
    @RequestLine("POST")
    public ItemResponse createItem(ItemRequest request);

    @RequestLine("PUT")
    public ItemResponse updateItem(ItemRequest request);
    
}
