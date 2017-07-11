package com.ruelala.returns.fedex.service;

import com.ruelala.returns.fedex.api.ItemsApi;
import com.ruelala.returns.fedex.api.LabelsApi;
import com.ruelala.returns.fedex.api.ReceiptsApi;
import com.ruelala.returns.fedex.api.RmasApi;

public interface FedExApiFactory {

    /**
     * Build an @ItemsApi instance.
     * 
     * @return the API instance
     */
    ItemsApi buildItemsApi();

    /**
     * Build an @RmasApi instance.
     * 
     * @return the API instance
     */
    RmasApi buildRmasApi();

    /**
     * Build an @LabelsApi instance.
     * 
     * @return the API instance
     */
    LabelsApi buildLabelsApi();

    /**
     * Build an @ReceiptsApi instance.
     * 
     * @return the API instance
     */
    ReceiptsApi buildReceiptsApi();

}