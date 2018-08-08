package com.anjan.mockitounittesttutorial.exercise.eventbus;

import com.anjan.mockitounittesttutorial.exercise.users.User;


public class UserDetailsChangedEvent {

    private final User mUser;

    public UserDetailsChangedEvent(User user) {
        mUser = user;
    }



    public User getUser() {
        return mUser;
    }
}
