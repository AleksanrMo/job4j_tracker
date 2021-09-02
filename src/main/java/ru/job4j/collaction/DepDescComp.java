package ru.job4j.collaction;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] temp = o1.split("/");
        String[] temp1 = o2.split("/");
        int rsl = temp1[0].compareTo(temp[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
       return rsl;
    }
}
