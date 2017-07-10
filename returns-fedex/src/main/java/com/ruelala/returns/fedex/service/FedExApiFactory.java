package com.ruelala.returns.fedex.service;

import com.ruelala.returns.fedex.api.ItemsApi;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.httpclient.ApacheHttpClient;
import feign.slf4j.Slf4jLogger;

public class FedExApiFactory {
    private final FedExConfiguration config;

    public FedExApiFactory(FedExConfiguration config) {
        super();
        this.config = config;
    }

    public ItemsApi buildItemsApi() {

        final RequestInterceptor authInterceptor = new FedexAuthHeadersInterceptor(
                config.getOrigin(),
                config.getClientId(),
                config.getClientSecret(),
                config.getCustomerId(),
                config.getAccessToken());

        return Feign.builder()
                .client(new ApacheHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ItemsApi.class))
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(authInterceptor)
                .target(ItemsApi.class, config.getItemsBaseAddress());
    }

}
