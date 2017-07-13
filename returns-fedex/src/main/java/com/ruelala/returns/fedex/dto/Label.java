package com.ruelala.returns.fedex.dto;

public class Label {
//    private Long id;
    private String id;
    private String labelURL;
    private String trackingNumber;
    private String labelContent;

    public Label() {
        // Default constructor
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Label [id=").append(id).append(", labelURL=").append(labelURL).append(", trackingNumber=").append(trackingNumber).append("]");
        return builder.toString();
    }
}
