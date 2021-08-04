package ru.job4j.inheritance;

public class Builder extends Engineer {

    private int numberOfObject;

    public Builder(String name, String surname, String education, int birthday,
                   String position, int numberOfObject) {
        super(name, surname, education, birthday, position);
        this.numberOfObject = numberOfObject;

    }

    public void buildHouse(House house) {

    }

}
