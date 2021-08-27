package ru.job4j.collaction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenAddDuplicateOrder() {
        List<Order> orders = new ArrayList<>();
        Order one = new Order("12", "Table");
        Order two = new Order("13", "Stool");
        Order three = new Order("12", "Pan");
        orders.add(one);
        orders.add(two);
        orders.add(three);
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(2));

    }
}