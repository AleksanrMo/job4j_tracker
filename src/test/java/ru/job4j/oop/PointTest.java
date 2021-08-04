package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void  when10to21then2() {
        Point a = new Point(2, 1);
        Point b = new Point(1, 0);
        double out = a.distance(b);
        double expected =  1.41;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void   when10to20then2() {
        Point a = new Point(2, 1);
        Point b = new Point(0, 0);
        double out = a.distance(b);
        double expected =  2.23;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void   when00to20then2() {
        Point a = new Point(2, 0);
        Point b = new Point(0, 0);
        double out = a.distance(b);
        double expected =  2;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void   when30to02to00then3() {
        Point a = new Point(0, 0, 3);
        Point b = new Point(0, 2, 0);
        double out = a.distance3d(b);
        double expected =  3.6;
        Assert.assertEquals(expected, out, 0.01);
    }

}