package com.ruelala.returns.api.object;

public class LabelData {

    // private Long id;
    private String id;
    private String trackingNumber;
    private String mimeType;
    private byte[] labelContent;

    public LabelData() {
    }

    public LabelData(String id, String trackingNumber, String mimeType, byte[] labelContent) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.mimeType = mimeType;
        this.labelContent = labelContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // public LabelData(Long id, String trackingNumber, String mimeType, byte[] labelContent) {
    // this.id = id;
    // this.trackingNumber = trackingNumber;
    // this.mimeType = mimeType;
    // this.labelContent = labelContent;
    // }
    //
    // public Long getId() {
    // return id;
    // }
    //
    // public void setId(Long id) {
    // this.id = id;
    // }
    //
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(byte[] labelContent) {
        this.labelContent = labelContent;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("LabelData [id=").append(id).append(", trackingNumber=").append(trackingNumber).append(", mimeType=").append(mimeType)
                .append(", labelContent length=").append(labelContent.length).append("]");
        return builder.toString();
    }
}
