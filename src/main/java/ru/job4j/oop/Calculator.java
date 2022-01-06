package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {

        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumOllOperation(int y) {
        return  sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int y = 10;
        System.out.println(sum(y));
        System.out.println(calculator.multiply(y));
        System.out.println(minus(y));
        System.out.println(calculator.divide(y));
        System.out.println(calculator.sumOllOperation(y));
    }
}
