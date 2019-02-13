package com.anjan.mockitounittesttutorial;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class LocatorTestJunit5 {

    //region constants
    public static final int POINT_X = 1;
    public static final int POINT_Y = 1;
    //endregion constants

    //region helper fields

    //endregion helper fields
    static Locator SUT;
    @Mock
    static LocatorService locatorServiceMock;

    @BeforeAll
    static void setup() throws Exception {

        SUT = new Locator(locatorServiceMock);

    }

    @Test
    @DisplayName("1 + 1 = 2")
    void addTwoNumbers(){

        Locator locator = new Locator(locatorServiceMock);
        assertEquals(2, locator.add(1, 1));
    }


    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {

        assertEquals(expectedResult, SUT.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    @Test
    void locator_passNegativeValue_positiveReturn() {

        Point point =  SUT.locate(-1, -1);
        assertThat(point.getX(), is(POINT_X));
    }


}