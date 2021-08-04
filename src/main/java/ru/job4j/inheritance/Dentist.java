package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private int licenseForImplant;

    public Dentist(String name, String surname, String education,
                   int birthday, String hospital, int licenseForImplant) {
        super(name, surname, education, birthday, hospital);
        this.licenseForImplant = licenseForImplant;
    }

    public void chekCaries(String check) {

    }

}
