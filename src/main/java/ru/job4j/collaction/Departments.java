package ru.job4j.collaction;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Collections;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.equals("") ?  el :  (start + "/" + el);
               tmp.add(start);
            }
        }

        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {

        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {

        orgs.sort(new DepDescComp());
    }
}