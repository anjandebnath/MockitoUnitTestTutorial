package com.anjan.mockitounittesttutorial.exercise.eventbus;

import com.anjan.mockitounittesttutorial.exercise.users.User;


public class UserDetailsChangedEvent {

    private User mUser;

    public UserDetailsChangedEvent(User user) {
        mUser = user;
    }



    public User getUser() {
        return mUser;
    }

    public void setUser(User user){

        this.mUser = user;
    }
}
