package com.ruelala;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ruelala.returns.fedex.dto.item.Item;
import com.ruelala.returns.fedex.service.FedExApiFactory;
import com.ruelala.returns.fedex.service.FedExConfiguration;
import com.ruelala.returns.fedex.service.FedExService;

/**
 * Unit test for simple App.
 */
public class FedexApiTest 
{
    private static final String TEST_SKU = "10081234120000";
    private static final String TEST_UPC = "1234123412341";
    private static final String TEST_NAME = "Test Name";
    
    private FedExService fedex;
    
    @Before
    public void before() {
        fedex = new FedExService(new FedExApiFactory(new FedExConfiguration()));
    }
    
    @After
    public void after() {
        // after stuff
    }
    
    @Test
    public void testRetrieveItem()
    {
        final Item item = fedex.findItem(TEST_SKU);
        assertThat(item.getUpc(), is(equalTo(TEST_UPC)));
        assertThat(item.getName(), is(equalTo(TEST_NAME)));
    }
}
