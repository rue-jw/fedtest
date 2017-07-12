package com.ruelala.returns.fedex.dto.label;

import com.ruelala.returns.api.object.LabelData;

public class LabelDtoFactory {

    private static final String DEFAULT_LABEL_MIME_TYPE = "application/pdf";
    
    public LabelData toLabelData(LabelsListResponse labelResponse) {
        final LabelData response = toLabelData(labelResponse.getLabels().get(0));
        
        return response;
    }

    public LabelData toLabelData(Label label) {
        final LabelData response = new LabelData(label.getId(), label.getTrackingNumber(), DEFAULT_LABEL_MIME_TYPE, label.getLabelContent().getBytes());
        return response;
    }


}
