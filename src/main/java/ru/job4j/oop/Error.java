package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String massage;

    public Error() {

    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(massage);
    }

    public static void main(String[] args) {
        Error first = new Error(true, 1, "ошибка в очереди на обработку");
        Error second = new Error(true, 2, "ошибка в очереди на обработку");
        Error third =  new Error();
        first.printInfo();
        System.out.println();
        second.printInfo();
        System.out.println();
        third.printInfo();
    }
}
