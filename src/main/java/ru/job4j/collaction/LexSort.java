package ru.job4j.collaction;

import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] lef = left.split(". ");
        String[] rig = right.split(". ");
        int leftInt = Integer.parseInt(lef[0]);
        int rightInt = Integer.parseInt(rig[0]);
        return Integer.compare(leftInt, rightInt);
    }
}
