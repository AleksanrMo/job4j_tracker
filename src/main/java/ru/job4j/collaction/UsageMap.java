package ru.job4j.collaction;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sushanta@mail.ru", "Kolin Aleksander Sergeevich ");
        map.put("email@mail.ru", "Korovin Andrey Petrovich");
        for (String key: map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
