package com.anjan.mockitounittesttutorial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Anjan Debnath on 5/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class LocatorTest {

    //**************************Creating mock objects with Mockito Starts*************************//
    /**
     * Mockito provides several methods to create mock objects:
     * 1. Using the @Mock annotation.
     * 2. Using the static mock() method.
     */

    // 1. Using the @Mock annotation
    /**
     * annotate the filed that is going to be mocked with @Mock and
     * annotate JUnit test class with @RunWith(MockitoJUnitRunner.class).
     * In this way Mockito runner does the initialization behind the scenes
     */
    @Mock
    private LocatorService locatorServiceMock;


    // 1. Using the static mock() method.
    @Test
    public void testUsingMockMethod(){
        LocatorService locatorServiceMockMethod = Mockito.mock(LocatorService.class);
    }
    //*************************Creating mock objects with Mockito Ends******************************//







    //************************Commonly used annotations begins*******************************************//

    private Locator locatorUnderTest;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //Method annotated with `@BeforeClass` will execute once before any of the test methods in this class.

    }

    @Before
    public void setUp() throws Exception{
        //Method annotated with `@Before` will execute before each test method in this class is executed.
        locatorUnderTest = new Locator(locatorServiceMock);
    }


    @After
    public void tearDown() throws Exception {
        //Method annotated with `@After` will execute after each test method in this class is executed.
    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //Method annotated with `@AfterClass` will execute once after all of the test methods are executed in this class.
    }

    //************************Commonly used annotations begins*******************************************//









    //********************************Assertions Begins*********************************//
    /**
     * assertThat method (available in JUnit4) which uses matchers
     */

    @Test
    public void testAssertThatExample(){
        // 'theString' should contain 'S' and 'r'
        // here 'both', 'containsString' are hamcrest core matchers
        // a list of hamcrest core matchers can be found on internet
        assertThat("theString", both(containsString("S")).and(containsString("r")));

        List<String> items = Arrays.asList("John", "James", "Julia", "Jim");

        // items list should have James and Jim
        assertThat(items, hasItems("James", "Jim"));
    }
    //*******************************Assertions Ends*****************************************//









    //*****************************Exception handle begins**********************************//
    /**
     * Following are the different ways you can test
     * that your method would throw the expected exception.
     */

    //Set the expected parameter @Test(expected = FileNotFoundException.class).
    @Test(expected = FileNotFoundException.class)
    public void testReadFile() throws IOException {
        FileReader reader = new FileReader("test.txt");
        reader.read();
        reader.close();
    }

    // using try catch
    @Test
    public void testReadFile2() {
        try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            assertThat(e.getMessage(), is("test.txt (No such file or directory)"));
        }

    }
    //*****************************Exception handle ends**********************************//




    //*************************when & then pattern begins****************************************

    @Test
    public void testPointValue(){
        when(locatorServiceMock.geoLocate(new Point(1,1))).thenReturn(new Point(11, 11));

        Point expected = new Point(1, 1);
        assertTrue(arePointsEqual(expected, locatorUnderTest.locate(-1, -1)));

    }

    private boolean arePointsEqual(Point p1, Point p2) {
        return p1.getX() == p2.getX()
                && p1.getY() == p2.getY();
    }
    //*****************when & then pattern ends*********************************************




    //***************************** spy ***********************************************************

    /**
     * Mockito.spy() – to spy on a real object.
     */
    @Test
    public void whenSpyingOnList_thenCorrect() {
        List<String> list = new ArrayList<String>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("one");
        spyList.add("two");

        Mockito.verify(spyList).add("one");
        Mockito.verify(spyList).add("two");

        assertEquals(2, spyList.size());
    }

}