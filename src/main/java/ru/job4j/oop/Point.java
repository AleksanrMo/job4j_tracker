package ru.job4j.oop;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2));
    }

    public double distance3d(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2)
                         +  Math.pow((this.z - that.z), 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0, 3);
        Point b = new Point(0, 2, 0);
        double dist = a.distance(b);
        System.out.println(dist);
        double dist3d = a.distance3d(b);
        System.out.println(dist3d);
    }
}
