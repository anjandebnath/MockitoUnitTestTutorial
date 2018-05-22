package com.anjan.mockitounittesttutorial;

import java.util.Random;

/**
 * Created by Anjan Debnath on 5/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class Utils {
    private static final Random RAND = new Random();

    private Utils() {
        // Utilities class
    }

    public static int randomDistance(int distance) {
        return RAND.nextInt(distance + distance) - distance;
    }
}
