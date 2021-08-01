package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Это " + this.name + " и он ел " + this.food + ".");

    }

    public void giveNick(String nick) {
        this.name = nick;

    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("котлету");
        gav.giveNick("Гав");
        gav.show();
        Cat black = new Cat();
        black.eat("рыбу");
        black.giveNick("Черный кот");
        black.show();

    }
}


