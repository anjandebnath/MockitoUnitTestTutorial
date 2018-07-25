package com.anjan.mockitounittesttutorial.mock;

import android.annotation.SuppressLint;

import java.time.LocalDate;

/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class LateInvoiceNotifier {

    private final EmailSender emailSender;
    private final InvoiceStorage invoiceStorage;
    private final EventRecorder eventRecorder;

    private static final String NAME = "Susan Ivanova";


    public LateInvoiceNotifier(final EmailSender emailSender, final InvoiceStorage invoiceStorage, EventRecorder eventRecorder){
        this.emailSender = emailSender;
        this.invoiceStorage = invoiceStorage;
        this.eventRecorder = eventRecorder;
    }

    @SuppressLint("NewApi")
    public void notifyLate(Customer customer){
        if(invoiceStorage.hasOutstandingInvoice(customer)){
            eventRecorder.recordEvent(new Event(Event.Type.REMINDER_SENT, NAME, LocalDate.now()));
            emailSender.sendEmail(customer);
        }
    }
}
