package ru.job4j.tracker;

import java.util.Comparator;

public class ItemCompareRevers implements Comparator<Item> {

    public int compare(Item one, Item two) {
        return Integer.compare(two.getId(), one.getId());
    }
}
