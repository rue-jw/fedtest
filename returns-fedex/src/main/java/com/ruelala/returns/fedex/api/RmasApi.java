package com.ruelala.returns.fedex.api;

import com.ruelala.returns.fedex.dto.rma.CancelRmaRequest;
import com.ruelala.returns.fedex.dto.rma.Rma;
import com.ruelala.returns.fedex.dto.rma.RmaListResponse;
import com.ruelala.returns.fedex.dto.rma.RmaResponse;
import com.ruelala.returns.fedex.dto.rma.RmasListResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers(value={"Accept: application/json"})
public interface RmasApi {

    @RequestLine("GET ?id={rmaId}&responseFilter=Summary")
    public RmaListResponse findRma(@Param("rmaId") String rmaId);

    @RequestLine("GET ?id={rmaId}&responseFilter=Details")
    public RmaListResponse findRmaDetail(@Param("rmaId") String rmaId);
    
    @RequestLine("POST")
    public RmasListResponse createRma(Rma rma);

    @RequestLine("POST /{rmaId}/cancel")
    public RmaResponse cancelRma(@Param("rmaId") String rmaId, CancelRmaRequest request);
    
}
