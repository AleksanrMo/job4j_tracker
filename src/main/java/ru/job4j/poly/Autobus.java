package ru.job4j.poly;

public class Autobus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по асфальту");
    }

    @Override
    public void speed() {
        System.out.println("Пасажирский " + getClass().getSimpleName()
                + " развивает скороть 80 км/ч.");
    }
}
