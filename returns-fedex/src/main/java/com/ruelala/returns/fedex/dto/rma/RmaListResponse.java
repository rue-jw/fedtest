package com.ruelala.returns.fedex.dto.rma;

import java.util.List;

import com.ruelala.returns.fedex.dto.base.BaseResponse;

public class RmaListResponse extends BaseResponse {

    private List<Rma> rmas;

    public RmaListResponse() {
    }

    public RmaListResponse(List<Rma> rmas) {
        this.rmas = rmas;
    }

    public List<Rma> getRmas() {
        return rmas;
    }

    public void setRmas(List<Rma> rmas) {
        this.rmas = rmas;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("RmaListResponse [rmas=").append(rmas).append(", requestIdentifier=").append(requestIdentifier).append(", transactionDate=")
                .append(transactionDate).append(", success=").append(success).append(", errors=").append(errors).append("]");
        return builder.toString();
    }

}
