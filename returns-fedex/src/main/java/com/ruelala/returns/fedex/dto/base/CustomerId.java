package com.ruelala.returns.fedex.dto.base;

public class CustomerId {
    protected String id;

    public CustomerId() {
    }

    public CustomerId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("CustomerId [id=").append(id).append("]");
        return builder.toString();
    }

}
