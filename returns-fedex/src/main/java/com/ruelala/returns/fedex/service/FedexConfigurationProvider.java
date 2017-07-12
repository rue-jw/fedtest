package com.ruelala.returns.fedex.service;

public interface FedexConfigurationProvider {

    /**
     * URI for Items API
     * @return
     */
    String getItemsBaseAddress();

    /**
     * URI for Rmas API
     * @return
     */
    String getRmasBaseAddress();

    /**
     * URI for Receipts API
     * @return
     */
    String getReceiptsBaseAddress();

    /**
     * URI for Labels API
     * @return
     */
    String getLabelsBaseAddress();

    /**
     * Client ID for the FedEx supply chain client application
     * @return
     */
    String getClientId();

    /**
     * Client Secret for the FedEx supply chain client application
     * @return
     */
    String getClientSecret();

    /**
     * Whitelisted origin header string for FedEx supply chain API
     * @return
     */
    String getOrigin();

    /**
     * Numeric customer ID assigned to the integration partner by FedEx supply chain
     * @return
     */
    String getCustomerId();

    /**
     * Access token assigned to the integration partner by FedEx supply chain
     * @return
     */
    String getAccessToken();

}