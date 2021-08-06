package ru.job4j.tracker;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item one = new Item();
        Item two = new Item(2, "test");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = one.getCreated().format(formatter);
        System.out.println(currentDateTimeFormat);
        System.out.println(two);
    }
}
