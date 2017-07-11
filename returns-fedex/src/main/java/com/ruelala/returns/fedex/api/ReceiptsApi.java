package com.ruelala.returns.fedex.api;

import feign.Headers;
import feign.RequestLine;

@Headers(value={"Accept: application/json"})
public interface ReceiptsApi {
    
    /**
     * Retrieves Receipts information.
     * <a>https://developer-sandbox.supplychain.fedex.com/sandbox/getreceipts</a>
     * 
     * TODO: fix return Object
     * 
     * @return
     */
    @RequestLine("GET ")
    public Object findReceipts();
    
}
