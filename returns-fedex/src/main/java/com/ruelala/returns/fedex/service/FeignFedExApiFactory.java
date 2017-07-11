package com.ruelala.returns.fedex.service;

import com.ruelala.returns.fedex.api.ItemsApi;
import com.ruelala.returns.fedex.api.LabelsApi;
import com.ruelala.returns.fedex.api.ReceiptsApi;
import com.ruelala.returns.fedex.api.RmasApi;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.httpclient.ApacheHttpClient;
import feign.slf4j.Slf4jLogger;

public class FeignFedExApiFactory implements FedExApiFactory {
    private static final Logger.Level API_LOGGING_LEVEL = Logger.Level.FULL;

    private final FedExConfiguration config;

    public FeignFedExApiFactory(FedExConfiguration config) {
        super();
        this.config = config;
    }

    /**
     * Build an @ItemsApi instance.
     * 
     * @return the API instance
     */
    @Override
    public ItemsApi buildItemsApi() {

        return Feign.builder()
                .client(new ApacheHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ItemsApi.class))
                .logLevel(API_LOGGING_LEVEL)
                .requestInterceptor(this.buildAuthInterceptor())
                .target(ItemsApi.class, config.getItemsBaseAddress());
    }

    /**
     * Build an @RmasApi instance.
     * 
     * @return the API instance
     */
    @Override
    public RmasApi buildRmasApi() {

        return Feign.builder()
                .client(new ApacheHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(RmasApi.class))
                .logLevel(API_LOGGING_LEVEL)
                .requestInterceptor(this.buildAuthInterceptor())
                .target(RmasApi.class, config.getRmasBaseAddress());
    }

    /**
     * Build an @LabelsApi instance.
     * 
     * @return the API instance
     */
    @Override
    public LabelsApi buildLabelsApi() {

        return Feign.builder()
                .client(new ApacheHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(LabelsApi.class))
                .logLevel(API_LOGGING_LEVEL)
                .requestInterceptor(this.buildAuthInterceptor())
                .target(LabelsApi.class, config.getLabelsBaseAddress());
    }

    /**
     * Build an @ReceiptsApi instance.
     * 
     * @return the API instance
     */
    @Override
    public ReceiptsApi buildReceiptsApi() {

        return Feign.builder()
                .client(new ApacheHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ReceiptsApi.class))
                .logLevel(API_LOGGING_LEVEL)
                .requestInterceptor(this.buildAuthInterceptor())
                .target(ReceiptsApi.class, config.getReceiptsBaseAddress());
    }

    /**
     * Build @FedexAuthHeadersInterceptor to add authorization headers for FedEx API calls.
     * 
     * @return the @RequestInterceptor
     */
    private RequestInterceptor buildAuthInterceptor() {

        return new FedexAuthHeadersInterceptor(
                config.getOrigin(),
                config.getClientId(),
                config.getClientSecret(),
                config.getCustomerId(),
                config.getAccessToken());
    }

}
