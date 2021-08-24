package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    //private final Item[] items = new Item[100];
    private int ids = 1;
    //private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
       if (index != -1) {
           item.setId(id);
           items.set(index, item);
           result = true;
       }
        return result;
    }

    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            list.add(item);
        }
        return list;
    }

    public List<Item> findByName(String key) {
        List<Item> test = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                test.add(item);
            }
        }
        return  test;
    }

    public boolean delete(int id) {
        boolean rst = false;
        int index = indexOf(id);
        if (index != -1) {
           items.remove(index);
            rst = true;
        }
        return rst;
        }
    }

