package com.anjan.mockitounittesttutorial;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by Anjan Debnath on 7/24/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocatorTest {

    //region constants
    public static final int POINT_X = 1;
    public static final int POINT_Y = 1;
    //endregion constants

    //region helper fields

    //endregion helper fields
    Locator SUT;
    @Mock
    LocatorService locatorServiceMock;

    @Before
    public void setup() throws Exception {

        SUT = new Locator(locatorServiceMock);

    }

    //region readme
    /**
     * we will use Argument Captor AC to verify mock object.
     * Assert must be called after any verify with AC.
     */
    //endregion readme
    @Test
    public void locator_passPositiveValueToLocatorService_success() {
        ArgumentCaptor<Point> pointAc = ArgumentCaptor.forClass(Point.class);
        SUT.locate(POINT_X, POINT_Y);
        verify(locatorServiceMock).geoLocate(pointAc.capture());
        Point point = pointAc.getValue();
        assertThat(point.getX(), is(equalTo(POINT_X)));
        assertThat(point.getY(), is(equalTo(POINT_Y)));
    }

    @Test
    public void locator_passNegativeValue_positiveReturn() {

        Point point =  SUT.locate(-1, -1);
        assertThat(point.getX(), is(POINT_X));
    }


    //region readme
    /**
     * when the test class's method return any result
     * that is dependent to the mock object then that
     * mock object should be stubbed.
     */
    //endregion readme
    @Test
    public void locator_positiveValue_returnPointSuccess() {

        //Stubbing locator service
        when(locatorServiceMock.geoLocate(any(Point.class))).thenReturn(new Point(POINT_X, POINT_Y));

        Point point = SUT.locate(POINT_X, POINT_Y);
        assertThat(point.getX(), is(POINT_X));

    }

    //region helper methods

    //endregion helper methods

    //region helper classes

    //endregion helper classes

}