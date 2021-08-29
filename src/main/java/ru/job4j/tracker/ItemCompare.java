package ru.job4j.tracker;

import java.util.Comparator;

public class ItemCompare implements Comparator<Item> {

    public int compare(Item one, Item two) {
        return Integer.compare(one.getId(), two.getId());
    }
}
