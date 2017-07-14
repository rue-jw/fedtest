package com.ruelala.returns.fedex.service;

import org.springframework.stereotype.Service;

import com.ruelala.returns.api.object.LabelData;
import com.ruelala.returns.api.object.ReturnRequest;
import com.ruelala.returns.api.object.ReturnResponse;
import com.ruelala.returns.fedex.api.ItemsApi;
import com.ruelala.returns.fedex.api.LabelsApi;
import com.ruelala.returns.fedex.api.ReceiptsApi;
import com.ruelala.returns.fedex.api.RmasApi;
import com.ruelala.returns.fedex.dto.Item;
import com.ruelala.returns.fedex.dto.ItemRequest;
import com.ruelala.returns.fedex.dto.ItemResponse;
import com.ruelala.returns.fedex.dto.ItemsListResponse;
import com.ruelala.returns.fedex.dto.LabelsListResponse;
import com.ruelala.returns.fedex.dto.Rma;
import com.ruelala.returns.fedex.dto.RmaListResponse;
import com.ruelala.returns.fedex.dto.RmasListResponse;
import com.ruelala.returns.fedex.dto.factory.ItemResponseConverter;
import com.ruelala.returns.fedex.dto.factory.LabelResponseConverter;
import com.ruelala.returns.fedex.dto.factory.RmaRequestConverter;
import com.ruelala.returns.fedex.dto.factory.RmaResponseConverter;

@Service
public class FedExService {

    private final ItemsApi itemsApi;
    private final RmasApi rmasApi;
    private final LabelsApi labelsApi;
    private final ReceiptsApi receiptsApi;
    private final ItemResponseConverter itemResponseConverter;
    private final RmaRequestConverter rmaRequestConverter;
    private final RmaResponseConverter rmaResponseConverter;
    private final LabelResponseConverter labelResponseConverter;

    public FedExService(FedExApiFactory factory, ItemResponseConverter itemResponseConverter, RmaRequestConverter rmaRequestConverter,
            RmaResponseConverter rmaResponseConverter, LabelResponseConverter labelResponseConverter) {
        super();

        this.itemsApi = factory.buildItemsApi();
        this.rmasApi = factory.buildRmasApi();
        this.labelsApi = factory.buildLabelsApi();
        this.receiptsApi = factory.buildReceiptsApi();

        this.itemResponseConverter = itemResponseConverter;
        this.rmaRequestConverter = rmaRequestConverter;
        this.rmaResponseConverter = rmaResponseConverter;
        this.labelResponseConverter = labelResponseConverter;
    }

    /* ITEMS */

    public Item findItem(String sku) {
        final ItemsListResponse response = itemsApi.findItem(sku);

        return response.getItems().get(0);
    }

    public Boolean createItem(Item item) {
        final ItemRequest request = new ItemRequest(item);
        final ItemResponse response = itemsApi.createItem(request);

        return response.isSuccess();
    }

    public Boolean updateItem(Item item) {
        final ItemRequest request = new ItemRequest(item);
        final ItemResponse response = itemsApi.updateItem(request);

        return response.isSuccess();
    }

    /* RMAS */

    public ReturnResponse createRma(ReturnRequest returnRequest) {
        final Rma rma = rmaRequestConverter.createRequest(returnRequest);
        final RmasListResponse response = rmasApi.createRma(rma);

        return rmaResponseConverter.toReturnResponse(response);
    }

    public Rma findRma(String rmaId) {
        final RmaListResponse response = rmasApi.findRmaDetail(rmaId);

        return response.getRma().get(0);
    }

    /* LABELS */

    public LabelData fetchLabelByRmaId(String rmaId) {
        final RmaListResponse rmaResponse = rmasApi.findRma(rmaId);
        final Rma rma = rmaResponse.getRma().get(0);

        final Long labelId = Long.parseLong(rma.getLabel().getId());

        return fetchLabelById(labelId);
    }

    public LabelData fetchLabelById(Long labelId) {

        final LabelsListResponse labelResponse = labelsApi.findLabel(labelId);

        return labelResponseConverter.toLabelData(labelResponse);
    }

}
