package com.anjan.mockitounittesttutorial;



/**
 * Created by Anjan Debnath on 5/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class Locator {
    private final LocatorService locatorService;

    private static Cache cache = new Cache();

    public Locator(LocatorService locatorService) {
        this.locatorService = locatorService;
    }

    public Point locate(int x, int y) {
        if (x < 0 || y < 0) {
            return new Point(Math.abs(x), Math.abs(y));
        } else {
            return locatorService.geoLocate(new Point(x, y));
        }
    }


}
