package com.ruelala.returns.fedex.api;

import java.io.File;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface LabelsApi {

    /**
     * Retrieves Label information as JSON with Base64 encoded PDF data.
     * See <a href="https://developer-sandbox.supplychain.fedex.com/sandbox/getlabel">API Docs</a>
     * 
     * TODO: fix return Object
     * 
     * @return
     */
    @RequestLine("GET /s{labelId}")
    @Headers(value={"Accept: application/json"})
    public Object findLabel(@Param("labelId") String labelId);

    /**
     * Retrieves Label information as binary PDF document.
     * See <a href="https://developer-sandbox.supplychain.fedex.com/sandbox/getlabel">API Docs</a>
     * 
     * @return
     */
    @RequestLine("GET /{labelId}")
    @Headers(value={"Accept: application/pdf"})
    public File findLabelPdf(@Param("labelId") String labelId);
    
}
