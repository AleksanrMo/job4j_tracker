package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemCompareReversTest  {
    @Test
    public void whenSortReversOrderIndex0is3() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1, "Alex");
        Item item2 = new Item(2, "Ivan");
        Item item3 = new Item(3, "Oleg");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Collections.sort(items, new ItemCompareRevers());
        assertThat(items.get(0).getId(), is(3));
    }

    @Test
    public void whenSortReversOrderEquals() {
        Item item1 = new Item(1, "Alex");
        Item item2 = new Item(2, "Ivan");
        Item item3 = new Item(3, "Oleg");
        List<Item> items = Arrays.asList(item2, item3, item1);
        List<Item> expected = List.of(item3, item2, item1);
        Collections.sort(items, new ItemCompareRevers());
        assertEquals(expected, items);
    }
}