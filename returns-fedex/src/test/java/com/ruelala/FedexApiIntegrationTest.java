package com.ruelala;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ruelala.returns.api.object.LabelData;
import com.ruelala.returns.fedex.dto.item.Item;
import com.ruelala.returns.fedex.dto.label.LabelDtoFactory;
import com.ruelala.returns.fedex.dto.rma.Rma;
import com.ruelala.returns.fedex.dto.rma.RmaDtoFactory;
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

    private FedExService fedex;

    @Before
    public void before() {
        this.fedex = new FedExService(
                new FeignFedExApiFactory(new TestFedExConfiguration()),
                        new RmaDtoFactory(),
                        new LabelDtoFactory()
                );
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
    public void testRetrieveLabel() {
        final LabelData label = fedex.fetchLabelById(EXISTS_LABEL_ID);
        
        //assertThat(label.getId(), is(equalTo(EXISTS_LABEL_ID.toString())));
        assertThat(label.getMimeType(), is(equalTo("application/pdf")));
        assertThat(label.getLabelContent(), is(not(nullValue())));
        assertThat(label.getLabelContent().length, is(greaterThan(1000)));
    }
}
