package com.anjan.mockitounittesttutorial;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<MessagingService> services = new ArrayList<>();

    public MessagingService getService(String serviceName) {
        // retrieve from the list
        return new EmailService();
    }

    public void addService(MessagingService newService) {
        // add to the list
    }
}
