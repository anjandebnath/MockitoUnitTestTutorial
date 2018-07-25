package com.anjan.mockitounittesttutorial.mock;

import java.time.LocalDate;

/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class Event {

    public enum Type  {REMINDER_SENT, REGISTRATION, INVOICE_ISSUED,PAYMENT, SETTLEMENT};

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    private Type type;
    private String customerName;
    private LocalDate timestamp;

    Event(Type type, String customerName, LocalDate timestamp){
        this.type = type;
        this.customerName = customerName;
        this.timestamp = timestamp;
    }

}
