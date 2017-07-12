package com.ruelala.returns.fedex.api;

import java.io.File;

import com.ruelala.returns.fedex.dto.label.LabelsListResponse;

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
    @RequestLine("GET /{labelId}")
    @Headers(value={"Accept: application/json"})
    public LabelsListResponse findLabel(@Param("labelId") Long labelId);

    /**
     * Retrieves Label information as binary PDF document.
     * See <a href="https://developer-sandbox.supplychain.fedex.com/sandbox/getlabel">API Docs</a>
     * 
     * @return
     */
    @RequestLine("GET /{labelId}")
    @Headers(value={"Accept: application/pdf"})
    public File findLabelPdf(@Param("labelId") Long labelId);
    
}
