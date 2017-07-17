package com.ruelala.returns.fedex.dto.factory;

import com.ruelala.returns.api.object.ReturnResponse;
import com.ruelala.returns.fedex.dto.Label;
import com.ruelala.returns.fedex.dto.Rma;
import com.ruelala.returns.fedex.dto.RmasListResponse;
import com.ruelala.returns.fedex.service.FedExConfigurationProvider;

public class RmaResponseConverter {

    // TODO: Remove if not necessary
    private final FedExConfigurationProvider config;
    
    public RmaResponseConverter(FedExConfigurationProvider config) {
        super();
        this.config = config;
    }

    public ReturnResponse toReturnResponse(RmasListResponse response) {
        final ReturnResponse returnResponse = new ReturnResponse();
        
        final Rma rma = response.getRmas().get(0);
        returnResponse.setDestinationId(rma.getShipToAddressId());
        returnResponse.setDestinationName(rma.getShipToAddressName());
        returnResponse.setRmaId(rma.getRmaId());
        returnResponse.setRmaNumber(rma.getRmaNumber());
        returnResponse.setShippingCost(rma.getShippingCost());
        
        final Label label = rma.getLabel();
        returnResponse.setLabelId(label.getId());
        returnResponse.setTrackingNumber(label.getTrackingNumber());
        
        return returnResponse;
    }

}
