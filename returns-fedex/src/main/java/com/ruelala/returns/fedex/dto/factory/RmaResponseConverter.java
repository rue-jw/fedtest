package com.ruelala.returns.fedex.dto.factory;

import com.ruelala.returns.api.object.ReturnResponse;
import com.ruelala.returns.fedex.dto.RmasListResponse;
import com.ruelala.returns.fedex.service.FedExConfigurationProvider;

public class RmaResponseConverter {

    private final FedExConfigurationProvider config;
    
    public RmaResponseConverter(FedExConfigurationProvider config) {
        super();
        this.config = config;
    }

    public ReturnResponse toReturnResponse(RmasListResponse response) {
        // TODO Auto-generated method stub
        return null;
    }

}
