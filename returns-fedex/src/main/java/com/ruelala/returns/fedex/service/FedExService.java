package com.ruelala.returns.fedex.service;

import org.springframework.stereotype.Service;

import com.ruelala.returns.api.object.LabelData;
import com.ruelala.returns.api.object.RmaData;
import com.ruelala.returns.fedex.api.ItemsApi;
import com.ruelala.returns.fedex.api.LabelsApi;
import com.ruelala.returns.fedex.api.ReceiptsApi;
import com.ruelala.returns.fedex.api.RmasApi;
import com.ruelala.returns.fedex.dto.item.Item;
import com.ruelala.returns.fedex.dto.item.ItemRequest;
import com.ruelala.returns.fedex.dto.item.ItemResponse;
import com.ruelala.returns.fedex.dto.item.ItemsListResponse;
import com.ruelala.returns.fedex.dto.label.LabelDtoFactory;
import com.ruelala.returns.fedex.dto.label.LabelsListResponse;
import com.ruelala.returns.fedex.dto.rma.Rma;
import com.ruelala.returns.fedex.dto.rma.RmaDtoFactory;
import com.ruelala.returns.fedex.dto.rma.RmaListResponse;
import com.ruelala.returns.fedex.dto.rma.RmasListResponse;

@Service
public class FedExService {

    private final ItemsApi itemsApi;
    private final RmasApi rmasApi;
    private final LabelsApi labelsApi;
    private final ReceiptsApi receiptsApi;
    private final RmaDtoFactory rmaDtoFactory;
    private final LabelDtoFactory labelDtoFactory;
    
    public FedExService(FedExApiFactory factory, RmaDtoFactory rmaDtoFactory, LabelDtoFactory labelDtoFactory) {
        super();
        
        this.itemsApi = factory.buildItemsApi();
        this.rmasApi = factory.buildRmasApi();
        this.labelsApi = factory.buildLabelsApi();
        this.receiptsApi = factory.buildReceiptsApi();
        
        this.rmaDtoFactory = rmaDtoFactory;
        this.labelDtoFactory = labelDtoFactory;
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
    
    public Boolean createRma(RmaData rmaData) {
        final Rma rma = rmaDtoFactory.createRequest(rmaData);
        final RmasListResponse response = rmasApi.createRma(rma);
        
        return response.isSuccess();
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
        
        return labelDtoFactory.toLabelData(labelResponse);
    }

}
