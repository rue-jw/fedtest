package com.ruelala.returns.fedex.service;

import org.springframework.stereotype.Service;

import com.ruelala.returns.fedex.api.ItemsApi;
import com.ruelala.returns.fedex.dto.Item;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Service
public class FedexService {

    private final FedExConfiguration config;
    private final ItemsApi itemsApi;
    
    
    public FedexService(FedExConfiguration config) {
        super();
        this.config = config;
        
        itemsApi = buildItemsApi();
    }

    private ItemsApi buildItemsApi() {
        
        final RequestInterceptor authInterceptor = new FedexAuthHeadersInterceptor(
                config.getOrigin(),
                config.getClientId(),
                config.getClientSecret(),
                config.getCustomerId(),
                config.getAccessToken());
        
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ItemsApi.class))
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(authInterceptor)
                .target(ItemsApi.class, config.getItemsBaseAddress());
    }

    public Item findItem(String sku) {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean createItem(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean updateItem(Item item) {
        // TODO Auto-generated method stub
        return null;
    }

}
