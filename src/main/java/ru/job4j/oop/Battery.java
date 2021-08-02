package ru.job4j.oop;

public class Battery {

    private int charge;

    public Battery(int size) {
        this.charge = size;
    }

    public void levelOfCharge(Battery another) {
        this.charge = this.charge - another.charge;
        another.charge = 0;
    }

    public static void main(String[] args) {
        Battery percentOfCharge = new Battery(100);
        Battery percentOfDischarge = new Battery(30);
        System.out.println("Charge of battery is complete: " + percentOfCharge.charge + "%");
        System.out.println("Battery discharge minus: " + percentOfDischarge.charge + "%");
        percentOfCharge.levelOfCharge(percentOfDischarge);
        System.out.println("Total remains: " + percentOfCharge.charge + "%");
    }
}
