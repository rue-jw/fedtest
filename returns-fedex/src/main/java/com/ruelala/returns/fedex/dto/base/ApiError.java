package com.ruelala.returns.fedex.dto.base;

public class ApiError {
    private String code;
    private String description;

    public ApiError() {
        // Default constructor
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiError [code=").append(code).append(", description=").append(description).append("]");
        return builder.toString();
    }

}
