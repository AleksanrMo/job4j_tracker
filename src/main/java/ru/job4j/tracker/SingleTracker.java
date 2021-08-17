package ru.job4j.tracker;

import java.util.Arrays;

public class SingleTracker {

    private static SingleTracker one = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {

}

public static SingleTracker getOne() {
        if (one == null) {
            one = new SingleTracker();
        }
        return one;
}

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
}

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }
    }
