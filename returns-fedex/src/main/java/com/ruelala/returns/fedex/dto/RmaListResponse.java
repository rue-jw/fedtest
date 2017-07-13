package com.ruelala.returns.fedex.dto;

import java.util.List;

import com.ruelala.returns.fedex.dto.base.BaseResponse;

public class RmaListResponse extends BaseResponse {

    private List<Rma> rma;

    public RmaListResponse() {
    }

    public List<Rma> getRma() {
        return rma;
    }

    public void setRma(List<Rma> rma) {
        this.rma = rma;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("RmaListResponse [rma=").append(rma).append(", requestIdentifier=").append(requestIdentifier).append(", transactionDate=")
                .append(transactionDate).append(", success=").append(success).append(", errors=").append(errors).append("]");
        return builder.toString();
    }

}
