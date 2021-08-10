package ru.job4j.poly;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам");
    }

    @Override
    public void speed() {
        System.out.println("Пасажирский " + getClass().getSimpleName()
                + " развивает скороть 140 км/ч.");
    }
}
