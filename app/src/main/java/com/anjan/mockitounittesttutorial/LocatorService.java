package com.anjan.mockitounittesttutorial;

/**
 * Created by Anjan Debnath on 5/22/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class LocatorService {
    public Point geoLocate(Point point) {
        return new Point(point.getX(), point.getY());
    }

    public Point generatePointWithinDistance(Point point, int distance) {
        return new Point(point.getX() + Utils.randomDistance(distance), point.getY() + Utils.randomDistance(distance));
    }
}
