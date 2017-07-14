package com.ruelala.returns.fedex.service;

public class TestFedExConfiguration implements FedExConfigurationProvider {

    @Override
    public String getItemsBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/items";
    }

    @Override
    public String getRmasBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/rmas";
    }
    
    @Override
    public String getReceiptsBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/receipts";
    }
    
    @Override
    public String getLabelsBaseAddress() {
        return "https://api-sandbox.supplychain.fedex.com/api/sandbox/v1/labels";
    }
    
    @Override
    public String getClientId() {
        return "78fbb4ed-2b6a-421e-b0f5-9d0b56931bfc";
    }

    @Override
    public String getClientSecret() {
        return "qR2oP6kV0kI0bY2cL3bU7sW7qV3bS2dB5jK2tF4nM5pS4xE0gX";
    }

    @Override
    public String getOrigin() {
        return "ruelala.com";
    }

    @Override
    public String getCustomerId() {
        return "10453";
    }

    @Override
    public String getAccessToken() {
        return "Uk1TMTA0NTNSdTVMMUwxNzIwMTcwNzA2";
    }

}
