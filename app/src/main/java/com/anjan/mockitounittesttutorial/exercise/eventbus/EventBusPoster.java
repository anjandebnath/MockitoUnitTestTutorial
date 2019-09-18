package com.anjan.mockitounittesttutorial.exercise.eventbus;

public interface EventBusPoster {

    void postEvent(Object event);

    void subscribeEvent(Object event);

    void unSubscribeEvent();

}
