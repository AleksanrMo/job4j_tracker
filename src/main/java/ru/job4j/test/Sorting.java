package ru.job4j.test;

import java.util.*;
import java.util.Comparator;

public class Sorting {
    public static void main(String[] args) {
        List<They> human = Arrays.asList(new They("Alex", "Builder", 24),
                new They("Boris", "Farmer", 65),
                new They("Yana", "Mom", 65));
//        List<They> humanAbc = human.stream()
//                .sorted(Comparator.comparing(They::getAge).reversed())
//                .collect(Collectors.toList());
       // System.out.println(humanAbc);
       human.sort(new PersonComparator().thenComparing(new PersonComparato()));
        System.out.println(human);
    }
}

class PersonComparator implements Comparator<They> {
    public int compare(They a, They b) {
        return Integer.compare(a.getAge(), b.getAge());
    }

}

class PersonComparato implements Comparator<They> {
    public int compare(They a, They b) {
        return a.getName().compareTo(b.getName());
    }   }