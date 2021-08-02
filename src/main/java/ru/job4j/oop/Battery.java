package ru.job4j.oop;

public class Battery {

    private int charge;

    public Battery(int size) {
        this.charge = size;
    }

    public void exchange(Battery another) {
        another.charge = this.charge + another.charge;
        this.charge = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(60);
        Battery second = new Battery(30);
        System.out.println("Charge of first battery is - " + first.charge + "%");
        System.out.println("Charge of second battery is -  " + second.charge + "%");
        first.exchange(second);
        System.out.println("After exchange of energy: first battery - " + first.charge + "%"
                           + " , second battery - " + second.charge + "%");
    }
}
