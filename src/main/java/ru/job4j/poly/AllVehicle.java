package ru.job4j.poly;

public class AllVehicle {
    public static void main(String[] args) {
        Vehicle bus = new Autobus();
        Vehicle train = new Train();
        Vehicle plane = new Plane();

        Vehicle[] vehicles = {bus, train, plane};
        for (Vehicle vehicle: vehicles) {
            vehicle.move();
            vehicle.speed();
        }
    }

}
