package com.anjan.mockitounittesttutorial.async.db;

import com.anjan.mockitounittesttutorial.mock.Customer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;


/**
 * Created by Anjan Debnath on 8/6/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoTest {
    public static final String JOHN = "John";
    public static final String DOUVER = "Douver";

    //region constants

    //endregion constants

    //region helper fields
    @Mock
    EntityManager entityManagerMock;
    @Mock
    Logger loggerMock;
    //endregion helper fields

    private CustomerDao SUT;

    @Before
    public void setup() throws Exception {

        SUT = new CustomerDao(entityManagerMock,loggerMock);

    }

    @Test
    public void dao_whenCustomerSaved_returnedCustomerId() {

        //arrange
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Customer customer = (Customer) invocation.getArguments()[0];
                customer.setId(123L);
                return null;
            }
        }).when(entityManagerMock).persist(any(Customer.class));

        //action
        SUT.saveCustomer(JOHN, DOUVER);
        //assert
        verify(loggerMock).info("Saved customer with id {}", 123L);

    }

    //region helper methods

    //endregion helper methods

    //region helper classes

    //endregion helper classes

}