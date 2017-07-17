package com.ruelala;

import static org.cthul.matchers.CthulMatchers._isA;
import static org.cthul.matchers.CthulMatchers.matchesPattern;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.ruelala.returns.api.object.LabelData;
import com.ruelala.returns.api.object.ReturnAddress;
import com.ruelala.returns.api.object.ReturnItem;
import com.ruelala.returns.api.object.ReturnOrder;
import com.ruelala.returns.api.object.ReturnRequest;
import com.ruelala.returns.api.object.ReturnResponse;
import com.ruelala.returns.fedex.dto.Item;
import com.ruelala.returns.fedex.dto.Rma;
import com.ruelala.returns.fedex.dto.factory.ItemResponseConverter;
import com.ruelala.returns.fedex.dto.factory.LabelResponseConverter;
import com.ruelala.returns.fedex.dto.factory.RmaRequestConverter;
import com.ruelala.returns.fedex.dto.factory.RmaResponseConverter;
import com.ruelala.returns.fedex.service.FedExConfigurationProvider;
import com.ruelala.returns.fedex.service.FedExService;
import com.ruelala.returns.fedex.service.FeignFedExApiFactory;
import com.ruelala.returns.fedex.service.TestFedExConfiguration;


/**
 * Unit test for simple App.
 */
public class FedexApiIntegrationTest {
    
    /*
     * Item
     */
    private static final String TEST_SKU = "10081234120000";
    private static final String TEST_UPC = "1234123412341";
    private static final String TEST_NAME = "Test Name";

    /*
     * Rma
     */
    private static final String EXISTS_RMA_ID = "10453-1649";
    private static final String EXISTS_RMA_NUMBER = "FX100000996";
    
    private static final String RMA_CUSTOMER_ADDRESSLINE1 = "1911 Shipaddy Ct";
    private static final String RMA_ORDER_NUMBER = "RMS-1451-03";
    private static final Long EXISTS_LABEL_ID = 5300l;
    
    /*
     * *** UPDATE THIS TO RUN THE CREATE_RMA TEST, OR IT WILL FAIL ON DUPLICATE ID ***
     */
    private static final String NEW_RMA_NUMBER = "TEST0000001";
    private static final Random RANDOM = new Random();
    
    private static <T extends Object> T pickAtRandom(T... hat) {
        return hat[RANDOM.nextInt(hat.length)];
    }
    
    private FedExService fedex;

    /* TEST STUFF */
    
    @Before
    public void before() {
        final FedExConfigurationProvider config = new TestFedExConfiguration();

        this.fedex = new FedExService(
                new FeignFedExApiFactory(config),
                new ItemResponseConverter(), new RmaRequestConverter(config), new RmaResponseConverter(config),
                new LabelResponseConverter());
    }

    @After
    public void after() {
        // after stuff
    }

    @Test
    public void testRetrieveItem() {
        final Item item = fedex.findItem(TEST_SKU);

        assertThat(item.getUpc(), is(equalTo(TEST_UPC)));
        assertThat(item.getName(), is(equalTo(TEST_NAME)));
    }

    @Test
    public void testRetrieveRma() {
        final Rma rma = fedex.findRma(EXISTS_RMA_ID);

        assertThat(rma.getRmaId(), is(equalTo(EXISTS_RMA_ID)));
        assertThat(rma.getRmaNumber(), is(equalTo(EXISTS_RMA_NUMBER)));
        assertThat(rma.getCustomer().getAddressLine1(), is(equalTo(RMA_CUSTOMER_ADDRESSLINE1)));
        assertThat(rma.getOrders().get(0).getOrderNumber(), is(equalTo(RMA_ORDER_NUMBER)));
    }

    @Test
    public void testCreateRma() {
        final ReturnRequest returnRequest = generateTestReturnRequest();
        final ReturnResponse returnResponse = fedex.createRma(returnRequest);
        
        System.out.println(returnResponse);
        
        assertThat(returnResponse.getRmaNumber(), is(equalTo(NEW_RMA_NUMBER)));
        assertThat(returnResponse.getTrackingNumber(), _isA(String.class).that(is(matchesPattern("[0-9]+"))));
    }

    private ReturnRequest generateTestReturnRequest() {
        final ReturnRequest req = new ReturnRequest();
        
        req.setRmaNumber(NEW_RMA_NUMBER);
        req.setVendorId("1");
        req.setShippingCostResponsibility("Retailer");
        req.setAddress(generateTestAddress());
        req.setOrders(generateTestOrders());
        req.setAdvanceCreditCode(pickAtRandom("AC", "GC", "DNC"));
        
        return req;
    }

    private List<ReturnOrder> generateTestOrders() {
        return Lists.newArrayList(generateTestOrder());
    }

    private ReturnOrder generateTestOrder() {
        final ReturnOrder order = new ReturnOrder();
        order.setItems(generateTestItems());
        order.setOrderDate("2017-04-25");
        order.setOrderNumber(RMA_ORDER_NUMBER);
        return order;
    }

    private List<ReturnItem> generateTestItems() {
        final String sku1 = "10002342350000";
        final String sku2 = "10002342360003";
        
        return Lists.newArrayList(generateTestItem(sku1), generateTestItem(sku2));
    }

    private ReturnItem generateTestItem(String sku) {
        final ReturnItem item = new ReturnItem();
        
        item.setSku(sku);
        item.setQuantity(1);
        item.setFinalSale(false);
        item.setReturnEligibilityOverride(false);
        item.setReturnReason("Wrong Size");
        
        return item;
    }

    private ReturnAddress generateTestAddress() {
        final ReturnAddress address = new ReturnAddress();
        
        address.setFirstName("Joe");
        address.setLastName("Jones");
        address.setAddressLine1(RMA_CUSTOMER_ADDRESSLINE1);
        address.setCity("Boston");
        address.setStateCode("MA");
        address.setZipCode("02120");
        address.setEmailAddress("ruetester2017@mailinator.com");
        address.setPhoneNumber("123-123-1234");
        
        return address;
    }

    @Test
    public void testRetrieveLabel() {
        final LabelData label = fedex.fetchLabelById(EXISTS_LABEL_ID);

        // assertThat(label.getId(), is(equalTo(EXISTS_LABEL_ID.toString())));
        assertThat(label.getMimeType(), is(equalTo("application/pdf")));
        assertThat(label.getLabelContent(), is(not(nullValue())));
        assertThat(label.getLabelContent().length, is(greaterThan(1000)));
    }
}
