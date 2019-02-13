package com.anjan.mockitounittesttutorial.mock;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentCaptor.*;
import static org.mockito.ArgumentMatchers.*;


/**
 * Created by Anjan Debnath on 7/25/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class LateInvoiceNotifierTest {

    //region constants

    //endregion constants

    //region helper fields
    private Customer sampleCustomer;
    @Mock
    EmailSender mEmailSenderMock;
    @Mock
    InvoiceStorage mInvoiceStorageMock;
    @Mock
    EventRecorder mEventRecorderMock;
    //endregion helper fields

    //Class to be tested
    LateInvoiceNotifier SUT;

    @Before
    public void setup() throws Exception {

        SUT = new LateInvoiceNotifier(mEmailSenderMock, mInvoiceStorageMock, mEventRecorderMock);

        //set once and used by all methods
        sampleCustomer = new Customer("Harie", "Kane");
        sampleCustomer.setFirstName("Harie");
        sampleCustomer.setLastName("Kane");


    }

    @Test
    public void notifier_foundLateInvoice_emailSendSuccess() throws Exception{

        //arrange
        //by stubbing we can return the value that will be true or false
        when(mInvoiceStorageMock.hasOutstandingInvoice(sampleCustomer)).thenReturn(true);

        //action
        SUT.notifyLate(sampleCustomer);

        //assert
        verify(mEmailSenderMock).sendEmail(sampleCustomer);

    }

    @Test
    public void notifier_noLateInvoice_emailSendFailed() {

        //arrange
        when(mInvoiceStorageMock.hasOutstandingInvoice(sampleCustomer)).thenReturn(false);

        //action
        SUT.notifyLate(sampleCustomer);

        /**
         * we want to make sure that the email method is NOT called.
         * Therefore, we also add the times argument to restrict
         * the number of times this method was (not) called.
         * If times is omitted it is assumed to be 1, which is what we do in the first test.
         */
        //assert
        verify(mEmailSenderMock, times(0)).sendEmail(sampleCustomer);

    }

    @Test
    public void notifier_foundLateInvoice_eventWithAC() {

        //arrange
        ArgumentCaptor<Event> myCaptor = ArgumentCaptor.forClass(Event.class);
        when(mInvoiceStorageMock.hasOutstandingInvoice(sampleCustomer)).thenReturn(true);

        //action
        SUT.notifyLate(sampleCustomer);

        //assert
        verify(mEmailSenderMock).sendEmail(sampleCustomer);

        verify(mEventRecorderMock).recordEvent(myCaptor.capture());

        Event eventThatWasSent = myCaptor.getValue();
        assertNotNull(eventThatWasSent.getTimestamp());
        assertEquals(Event.Type.REMINDER_SENT, eventThatWasSent.getType());
        assertEquals("Susan Ivanova",eventThatWasSent.getCustomerName());
    }

    //region helper methods


    //endregion helper methods

    //region helper classes

    //endregion helper classes

}