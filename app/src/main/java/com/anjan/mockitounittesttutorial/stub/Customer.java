package com.anjan.mockitounittesttutorial.stub;

/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

public class Customer {

    /**
     * DataStructure
     * Expose data
     * No behaviour
     * Can be instantiated with other Objects
     * No need to be substituted with test doubles
     */

    private long id;

    private String firstName;

    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
