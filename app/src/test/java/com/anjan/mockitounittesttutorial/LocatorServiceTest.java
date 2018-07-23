package com.anjan.mockitounittesttutorial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mock.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentCaptor.*;
import static org.mockito.ArgumentMatchers.*;


/**
 * Created by Anjan Debnath on 7/19/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocatorServiceTest {

    //region constants

    //endregion constants

    //region helper fields

    //endregion helper fields

    LocatorService SUT;

    @Before
    public void setup() throws Exception {

        SUT = new LocatorService();


    }

    //region helper methods

    //endregion helper methods

    //region helper classes

    //endregion helper classes

}