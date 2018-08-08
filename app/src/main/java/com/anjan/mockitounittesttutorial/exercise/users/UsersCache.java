package com.anjan.mockitounittesttutorial.exercise.users;

public interface UsersCache {

    void cacheUser(User user);

    User getUser(String userId);

}
