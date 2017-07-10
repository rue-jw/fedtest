package com.ruelala.returns.fedex.service;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FedexAuthHeadersInterceptor implements RequestInterceptor {

    private static final String ORIGIN_HEADER = "Origin";
    private static final String CLIENT_ID_HEADER = "X-IBM-Client-Id";
    private static final String CLIENT_SECRET_HEADER = "X-IBM-Client-Secret";
    private static final String CUSTOMER_ID_HEADER = "CustomerId";
    private static final String ACCESS_TOKEN_HEADER = "AccessToken";
    
    private final String origin;
    private final String clientId;
    private final String clientSecret;
    private final String customerId;
    private final String accessToken;
    
    public FedexAuthHeadersInterceptor(String origin, String clientId, String clientSecret, String customerId, String accessToken) {
        super();
        
        this.origin = origin;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.customerId = customerId;
        this.accessToken = accessToken;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header(ORIGIN_HEADER, this.origin);
        template.header(CLIENT_ID_HEADER, this.clientId);
        template.header(CLIENT_SECRET_HEADER, this.clientSecret);
        template.header(CUSTOMER_ID_HEADER, this.customerId);
        template.header(ACCESS_TOKEN_HEADER, this.accessToken);
    }

}
