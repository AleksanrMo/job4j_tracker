package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String programmingLeng;

    public Programmer(String name, String surname, String education, int birthday,
                   String position, String project, String programmingLeng) {
        super(name, surname, education, birthday, position);
        this.programmingLeng = programmingLeng;

    }

    public void checkStyle(File file) {

    }
}
