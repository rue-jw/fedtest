package com.ruelala.returns.fedex.dto.rma;

public class Label {
    private long id;
    private String labelURL;
    private String trackingNumber;

    public Label() {
        // Default constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabelURL() {
        return labelURL;
    }

    public void setLabelURL(String labelURL) {
        this.labelURL = labelURL;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Label [id=").append(id).append(", labelURL=").append(labelURL).append(", trackingNumber=").append(trackingNumber).append("]");
        return builder.toString();
    }
}
