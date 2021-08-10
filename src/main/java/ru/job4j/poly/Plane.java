package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по воздуху");
    }

    @Override
    public void speed() {
        System.out.println("Пасажирский " + getClass().getSimpleName()
                + " развивает скороть 800 км/ч.");
    }
}
