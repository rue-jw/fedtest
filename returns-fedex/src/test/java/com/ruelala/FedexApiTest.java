package com.ruelala;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ruelala.returns.fedex.dto.item.Item;
import com.ruelala.returns.fedex.dto.rma.Rma;
import com.ruelala.returns.fedex.service.FedExConfiguration;
import com.ruelala.returns.fedex.service.FedExService;
import com.ruelala.returns.fedex.service.FeignFedExApiFactory;

/**
 * Unit test for simple App.
 */
public class FedexApiTest {
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

    private FedExService fedex;

    @Before
    public void before() {
        fedex = new FedExService(new FeignFedExApiFactory(new FedExConfiguration()));
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
}
