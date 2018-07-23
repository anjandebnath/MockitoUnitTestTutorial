package com.anjan.mockitounittesttutorial.sync.networking;

/**
 * Created by Anjan Debnath on 7/23/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface LoginHttpEndpointSync {

    /**
     * Log in using provided credentials
     * @return the aggregated result of login operation
     * @throws NetworkErrorException if login attempt failed due to network error
     */
    EndpointResult loginSync(String username, String password) throws NetworkErrorException;

    enum EndpointResultStatus {
        SUCCESS,
        AUTH_ERROR,
        SERVER_ERROR,
        GENERAL_ERROR
    }

    class EndpointResult {
        private final EndpointResultStatus mStatus;
        private final String mAuthToken;

        public EndpointResult(EndpointResultStatus status, String authToken) {
            mStatus = status;
            mAuthToken = authToken;
        }

        public EndpointResultStatus getStatus() {
            return mStatus;
        }

        public String getAuthToken() {
            return mAuthToken;
        }
    }
}
