package com.ruelala.returns.fedex.dto.base;

import java.util.List;

public abstract class BaseResponse {

    protected String requestIdentifier;
    protected String transactionDate;
    protected boolean success = false;
    protected List<ApiError> errors;

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

    public List<ApiError> getErrors() {
        return errors;
    }

    public void setErrors(List<ApiError> errors) {
        this.errors = errors;
    }

}
