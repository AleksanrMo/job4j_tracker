package ru.job4j.collaction;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> firstArray = new ArrayList<>();
        firstArray.add("Alex");
        firstArray.add("Sergey");
        firstArray.add("Petr");
        for (Object value: firstArray) {
            System.out.println(value);
        }
    }
}
