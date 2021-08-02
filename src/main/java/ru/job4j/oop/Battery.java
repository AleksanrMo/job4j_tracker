package ru.job4j.oop;

public class Battery {

    private int charge;

    public Battery(int size) {
        this.charge = size;
    }

    public void exchange(Battery another) {
        this.charge = this.charge - another.charge;
        another.charge = this.charge;
    }

    public static void main(String[] args) {
        Battery percentOfCharge = new Battery(100);
        Battery percentOfDischarge = new Battery(30);
        System.out.println("Charge of battery is complete: " + percentOfCharge.charge + "%");
        System.out.println("Battery discharge minus: " + percentOfDischarge.charge + "%");
        percentOfCharge.exchange(percentOfDischarge);
        System.out.println("Total remains: " + percentOfDischarge.charge + "%");
    }
}
