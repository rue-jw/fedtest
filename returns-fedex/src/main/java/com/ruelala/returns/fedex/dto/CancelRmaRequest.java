package com.ruelala.returns.fedex.dto;

import com.ruelala.returns.fedex.dto.base.CustomerId;
import com.ruelala.returns.fedex.dto.base.CustomerIdEntity;

/**
 * Wrapper for superclass.
 * 
 * @author jonathan.williams
 */
public class CancelRmaRequest extends CustomerIdEntity {

    public CancelRmaRequest() {
    }

    public CancelRmaRequest(CustomerId customer) {
        super(customer);
    }
    
}
