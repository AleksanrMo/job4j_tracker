package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Автобус едет бысро.");
    }

    @Override
    public void passenger(int passengers) {
        System.out.println("В автобусе " + passengers + " пассажиров.");
    }

    @Override
    public int prise(int oilQuantity) {
        int prisePerLitre = 42;
        return prisePerLitre * oilQuantity;
    }
}
