package com.anjan.mockitounittesttutorial.async;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentCaptor.*;



/**
 * Created by Anjan Debnath on 7/23/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class DummyCallerTest {

    //region constants

    //endregion constants

    //region helper fields
    @Mock
    private DummyCollaborator mDummyCollaboratorMock;

    //endregion helper fields

    DummyCaller SUT;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        SUT = new DummyCaller(mDummyCollaboratorMock);

    }

    @Test
    /**
     *  stubbing a method with a generic Answer
     *  since we need a callback to return immediately (synchronously),
     *  we generate an answer so when the method under test is called,
     *  the callback will be executed right away with the data we tell it to return.
     */
    public void test_doSomethingAsynchronously_usingDoAnswer() {
        //arrange
        //here we stub the result
        final List<String> results = Arrays.asList("One", "Two", "Three");
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                ((DummyCallback)invocation.getArguments()[0]).onSuccess(results);
                return null;
            }
        }).when(mDummyCollaboratorMock).doSomethingAsynchronously(any(DummyCallback.class));
        //action
        SUT.doSomethingAsynchronously();
        //assert
        verify(mDummyCollaboratorMock).doSomethingAsynchronously(any(DummyCallback.class));
        assertThat(SUT.getResult(), is(equalTo(results)));
    }

    @Test
    public void test_doSomethingAsynchronously_usingArgumentCaptor() {

        //arrange
        ArgumentCaptor<DummyCallback> ac = ArgumentCaptor.forClass(DummyCallback.class);
        List<String> results = Arrays.asList("One", "Two", "Three");
        //action
        SUT.doSomethingAsynchronously();

        //assert
        verify(mDummyCollaboratorMock).doSomethingAsynchronously(ac.capture());
        // Some assertion about the state before the callback is called
        assertThat(SUT.getResult().isEmpty(), is(true));

        //trigger the reply on callbackCaptor.getValue().
        ac.getValue().onSuccess(results);

        //Some assertion about the state after the callback is called
        assertThat(SUT.getResult(), is(equalTo(results)));

    }

    //region helper methods

    //endregion helper methods

    //region helper classes

    //endregion helper classes

}