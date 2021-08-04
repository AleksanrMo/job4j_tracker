package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int numberOfOperation;

    public Surgeon(String name, String surname, String education,
                   int birthday, String hospital, int numberOfOperation) {
        super(name, surname, education, birthday, hospital);
       this.numberOfOperation = numberOfOperation;
    }

 public void needOfOperation(Patient patient) {

 }
}