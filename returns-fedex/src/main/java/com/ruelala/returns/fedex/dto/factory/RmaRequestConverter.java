package com.ruelala.returns.fedex.dto.factory;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;
import com.ruelala.returns.api.object.ReturnAddress;
import com.ruelala.returns.api.object.ReturnItem;
import com.ruelala.returns.api.object.ReturnOrder;
import com.ruelala.returns.api.object.ReturnRequest;
import com.ruelala.returns.fedex.dto.Customer;
import com.ruelala.returns.fedex.dto.Item;
import com.ruelala.returns.fedex.dto.Order;
import com.ruelala.returns.fedex.dto.ReturnItemInfo;
import com.ruelala.returns.fedex.dto.Rma;
import com.ruelala.returns.fedex.service.FedExConfigurationProvider;

public class RmaRequestConverter {

    private static final Boolean LABEL_REQUIRED = true;
    private final FedExConfigurationProvider config;
    
    public RmaRequestConverter(FedExConfigurationProvider config) {
        super();
        this.config = config;
    }

    public Rma createRequest(ReturnRequest returnRequest) {
        final Rma rma = new Rma();
        
        rma.setRmaNumber(returnRequest.getRmaNumber());
        rma.setCustomer(toCustomer(returnRequest.getAddress()));
        rma.setOrders(toOrders(returnRequest.getOrders()));
        rma.setEmailNotification(!Strings.isNullOrEmpty(returnRequest.getAddress().getEmailAddress()));
        rma.setShippingCostResponsibility(returnRequest.getShippingCostResponsibility());
        rma.setShipToAddressId(returnRequest.getVendorId());
        rma.setLabelRequired(LABEL_REQUIRED);
        
        return rma;
    }

    private List<Order> toOrders(List<ReturnOrder> returnOrders) {
        final List<Order> orders = new ArrayList<Order>();
        for (final ReturnOrder ro : returnOrders) {
            orders.add(toOrder(ro));
        }
        
        return orders;
    }

    private Order toOrder(ReturnOrder returnOrder) {
        final Order order = new Order();
        
        order.setOrderNumber(returnOrder.getOrderNumber());
        order.setOrderDate(returnOrder.getOrderDate());
        order.setItems(toItems(returnOrder.getItems()));
        
        return order;
    }

    private List<Item> toItems(List<ReturnItem> returnItems) {
        final List<Item> items = new ArrayList<Item>();
        for (final ReturnItem ri : returnItems) {
            items.add(toItem(ri));
        }
        
        return items;
    }

    private Item toItem(ReturnItem returnItem) {
        final Item item = new Item();
        
        item.setSku(returnItem.getSku());
        item.setQuantity(returnItem.getQuantity());
        final ReturnItemInfo rii = new ReturnItemInfo();
        rii.setReturnEligibilityOverride(returnItem.getReturnEligibilityOverride());
        rii.setReturnReason(returnItem.getReturnReason());
        rii.setFinalSale(returnItem.getFinalSale());
        // Advance credit code goes to specialty flag.
        rii.setSpecialtyFlag(returnItem.getAdvanceCreditCode());
        item.setReturnItemInfo(rii);
        
        return item;
    }

    private Customer toCustomer(ReturnAddress address) {
        final Customer customer = new Customer();
        
        // Customer must be populated with RUE's customerId. This has nothing to do with the customer.
        customer.setId(config.getCustomerId());
        
        customer.setFirstName(address.getFirstName());
        customer.setLastName(address.getLastName());
        customer.setAddressLine1(address.getAddressLine1());
        customer.setAddressLine2(address.getAddressLine2());
        customer.setCity(address.getCity());
        customer.setStateCode(address.getStateCode());
        customer.setZipCode(address.getZipCode());
        customer.setCountryCode(address.getCountryCode());
        customer.setPhoneNumber(address.getPhoneNumber());
        customer.setEmailAddress(address.getEmailAddress());
        
        return customer;
    }

}
