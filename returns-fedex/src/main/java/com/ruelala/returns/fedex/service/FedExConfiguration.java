package com.ruelala.returns.fedex.service;

public class FedExConfiguration {

    public String getItemsBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/items";
    }

    public String getRmasBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/rmas";
    }
    
    public String getReceiptsBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/receipts";
    }
    
    public String getLabelsBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/labels";
    }
    
    public String getClientId() {
        return "78fbb4ed-2b6a-421e-b0f5-9d0b56931bfc";
    }

    public String getClientSecret() {
        return "qR2oP6kV0kI0bY2cL3bU7sW7qV3bS2dB5jK2tF4nM5pS4xE0gX";
    }

    public String getOrigin() {
        return "ruelala.com";
    }

    public String getCustomerId() {
        return "10453";
    }

    public String getAccessToken() {
        return "Uk1TMTA0NTNSdTVMMUwxNzIwMTcwNzA2";
    }

}
