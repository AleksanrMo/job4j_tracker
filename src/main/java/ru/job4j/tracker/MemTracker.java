package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MemTracker implements Store {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {
    }

    @Override
    public void close() throws Exception {
    }

    @Override
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

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    @Override
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

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> test = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                test.add(item);
            }
        }
        return  test;
    }

    @Override
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

