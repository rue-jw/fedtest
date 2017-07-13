package com.ruelala.returns.fedex.dto;

import java.util.List;

import com.ruelala.returns.fedex.dto.base.BaseResponse;

public class LabelsListResponse extends BaseResponse {

    private List<Label> labels;

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("LabelsListResponse [labels=").append(labels).append(", requestIdentifier=").append(requestIdentifier).append(", transactionDate=")
                .append(transactionDate).append(", success=").append(success).append(", errors=").append(errors).append("]");
        return builder.toString();
    }

}
