package com.ruelala.returns.fedex.api;

import com.ruelala.returns.fedex.dto.Item;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(value={"Content-Type: application/json", "Accept: application/json"})
public interface ItemsApi {

    @RequestLine("GET /?responseFilter=SUMMARY&sku={sku}")
    public Item findItem(@Param("sku") String sku);

    @RequestLine("GET /?responseFilter=DETAIL&sku={sku}")
    public Item findItemDetails(@Param("sku") String sku);
    
    @RequestLine("POST /")
    public Boolean createItem(Item item);

    @RequestLine("PUT /")
    public Boolean updateItem(Item item);
    
}
