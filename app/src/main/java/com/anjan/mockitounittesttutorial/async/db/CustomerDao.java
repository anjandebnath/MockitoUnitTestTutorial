package com.anjan.mockitounittesttutorial.async.db;

import com.anjan.mockitounittesttutorial.mock.Customer;

/**
 * Created by Anjan Debnath on 8/6/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class CustomerDao {

    private EntityManager entityManager;

    private Logger logger;

    public CustomerDao(EntityManager entityManager, Logger logger){
        this.entityManager = entityManager;
        this.logger = logger;
    }

    /**
     * once the customer is saved using the persist method, its database ID is sent to the logger.
     * For this contrived example, the code will work just fine in the real system, as the database
     * will indeed assign an ID to the object as soon as it is saved.
     * But how can we replicate this processing in our unit test?
     * The persist method does not return an argument so we cannot mock it with the usual when/then directives.
     * However, even for this corner case, Mockito still has a solution:
     * @param firstName
     * @param lastName
     */
    public void saveCustomer(String firstName, String lastName) {
        if(firstName == null || lastName==null)
        {
            logger.error("Missing customer information");
            throw new IllegalArgumentException();
        }
        Customer customer = new Customer(firstName,lastName);
        entityManager.persist(customer);
        entityManager.flush();
        logger.info("Saved customer with id {}", customer.getId());
    }
}
