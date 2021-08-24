package ru.job4j.collaction;

import java.util.HashSet;

public class UsageHashSet {

    public static void main(String[] args) {

        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("Toyota");
        autos.add("Volvo");
        autos.add("BMW");
        for (String auto: autos) {
            System.out.println(auto);
        }
    }
}
