package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Иван Николаевич Васильев");
        student.setGroup(35);
        student.setDate("12.05.2019");
        System.out.println("Студент " + student.getName() + ", поступил "
                           + student.getDate() + ", номер группы - " + student.getGroup() + ".");
    }
}