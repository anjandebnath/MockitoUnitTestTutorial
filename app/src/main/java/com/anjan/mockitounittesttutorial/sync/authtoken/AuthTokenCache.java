package com.anjan.mockitounittesttutorial.sync.authtoken;

public interface AuthTokenCache {

    void cacheAuthToken(String authToken);

    String getAuthToken();
}
