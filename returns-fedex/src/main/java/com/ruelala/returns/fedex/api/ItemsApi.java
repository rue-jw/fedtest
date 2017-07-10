package com.ruelala.returns.fedex.api;

import com.ruelala.returns.fedex.dto.ItemRequest;
import com.ruelala.returns.fedex.dto.ItemResponse;
import com.ruelala.returns.fedex.dto.ItemsResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(value={"Content-Type: application/json", "Accept: application/json"})
public interface ItemsApi {

    @RequestLine("GET ?responseFilter=SUMMARY&sku={sku}")
    public ItemsResponse findItem(@Param("sku") String sku);

    @RequestLine("GET ?responseFilter=DETAIL&sku={sku}")
    public ItemsResponse findItemDetails(@Param("sku") String sku);
    
    @RequestLine("POST")
    public ItemResponse createItem(ItemRequest request);

    @RequestLine("PUT")
    public ItemResponse updateItem(ItemRequest request);
    
}
