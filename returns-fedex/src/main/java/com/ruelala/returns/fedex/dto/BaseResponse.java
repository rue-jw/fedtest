package com.ruelala.returns.fedex.dto;

public class BaseResponse {

    private String requestIdentifier;
    private String transactionDate;
    private boolean success = false;

    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BaseResponse [requestIdentifier=").append(requestIdentifier).append(", transactionDate=").append(transactionDate).append(", success=")
        .append(success).append("]");
        return builder.toString();
    }

}
