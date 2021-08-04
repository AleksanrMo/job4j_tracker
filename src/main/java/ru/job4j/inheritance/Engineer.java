package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String position;

    public Engineer(String name, String surname, String education,
                    int birthday, String position) {
    super(name, surname, education, birthday);
    this.position = position;

    }

    public String getPosition() {
        return position;
    }

    public void buildProject(Project project) {

    }
}
