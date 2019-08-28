package com.anjan.mockitounittesttutorial;

public class SMSService implements MessagingService {

    public String getMessageBody() {
        return "sms message";
    }

    public String getServiceName() {
        return "SMSService";
    }
}
