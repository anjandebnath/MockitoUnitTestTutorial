package com.anjan.mockitounittesttutorial.stub;

/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

public class DbManager {

    public static final String FIRST_NAME = "Customer";
    public static final String LAST_NAME = "Name";

    /**
     * Object
     * Expose behaviours
     * Hide internal implementation detail
     * Should be injected into other Objects
     * Need to be unit tested explicitly
     * Eligible to be substituted with test doubles
     */

    public Customer findCustomer(Long customerId){
        Customer customer = null;
        if(customerId > 0){
            customer = new Customer();
            /**
             * here will be the database fetch code
             * and from that fetched value we will get the
             * customer.
             */
            customer.setId(customerId);
            customer.setFirstName(FIRST_NAME);
            customer.setLastName(LAST_NAME);
        }
        return customer;
    }
}
