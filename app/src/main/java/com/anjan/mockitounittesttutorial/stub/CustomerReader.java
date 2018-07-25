package com.anjan.mockitounittesttutorial.stub;

/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

public class CustomerReader {

    private DbManager mDbManager;

    public CustomerReader(DbManager dbManager) {
        this.mDbManager = dbManager;
    }

    public String findName(Long customerID){
        Customer customer = mDbManager.findCustomer(customerID);
        return customer.getFirstName() +" "+customer.getLastName();
    }
}
