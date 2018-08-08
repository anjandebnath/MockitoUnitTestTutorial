package com.anjan.mockitounittesttutorial.stub;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerReaderTest {

    //region constants
    private static final long CUSTOMER_ID = 1L;
    private static final String CUSTOMER_NAME = "customer Name";
    public static final String FIRST_NAME = "Customer";
    public static final String LAST_NAME = "Name";
    //endregion constants

    //region helper fields
    @Mock
    DbManager dbManagerMock;
    //endregion helper fields

    CustomerReader SUT;

    @Before
    public void setup() throws Exception {

        SUT = new CustomerReader(dbManagerMock);

    }

    @Test
    public void test_customerIdPassed_nameReturned() {

        //arrange
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        when(dbManagerMock.findCustomer(CUSTOMER_ID)).thenReturn(customer);
        //action
        String name = SUT.findName(CUSTOMER_ID);
        //assert
        assertThat(name, is(equalTo(CUSTOMER_NAME)));
    }


    //region helper methods

    //endregion helper methods

    //region helper classes

    //endregion helper classes

}