package com.ruelala.returns.fedex.dto;

import com.ruelala.returns.fedex.dto.base.BaseResponse;

public class RmaResponse extends BaseResponse {

    private Rma rma;

    public RmaResponse() {
        // Default constructor
    }

    public Rma getRma() {
        return rma;
    }

    public void setRma(Rma rma) {
        this.rma = rma;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("RmaResponse [rma=").append(rma).append(", requestIdentifier=").append(requestIdentifier).append(", transactionDate=")
                .append(transactionDate).append(", success=").append(success).append(", errors=").append(errors).append("]");
        return builder.toString();
    }

}
