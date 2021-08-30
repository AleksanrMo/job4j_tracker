package ru.job4j.collaction;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenJobDescByName() {
     Job worker1 = new Job("Alex", 0);
     Job worker2 = new Job("Ivan", 1);
        List<Job> list = Arrays.asList(worker1, worker2);
        List<Job> expected = List.of(worker2, worker1);
        list.sort(new JobDescByName());
        assertEquals(expected, list);
    }

    @Test
    public void whenJobDescByPriority() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Ivan", 0);
        List<Job> list = Arrays.asList(worker1, worker2);
        List<Job> expected = List.of(worker1, worker2);
        list.sort(new JobDescByPriority());
        assertEquals(expected, list);
    }

    @Test
    public void whenJobIncreaseByPriority() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Ivan", 0);
        Job worker3 = new Job("Irina", 2);
        List<Job> list = Arrays.asList(worker1, worker2, worker3);
        List<Job> expected = List.of(worker2, worker1, worker3);
        list.sort(new JobIncreaseByPriority());
        assertEquals(expected, list);
    }

    @Test
    public void whenJobIncreaseByName() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Ivan", 0);
        Job worker3 = new Job("Irina", 2);
        List<Job> list = Arrays.asList(worker1, worker2, worker3);
        List<Job> expected = List.of(worker1, worker3, worker2);
        list.sort(new JobIncreaseByName());
        assertEquals(expected, list);
    }

    @Test
    public void whenJobIncreaseByNameAndIncreaseByPriority() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Alex", 0);
        Job worker3 = new Job("Irina", 2);
        List<Job> list = Arrays.asList(worker1, worker2, worker3);
        List<Job> expected = List.of(worker2, worker1, worker3);
        list.sort(new JobIncreaseByName().thenComparing(new JobIncreaseByPriority()));
        assertEquals(expected, list);
    }

    @Test
    public void whenJobIncreaseByNameAndDecreaseByPriority() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Alex", 0);
        Job worker3 = new Job("Irina", 2);
        List<Job> list = Arrays.asList(worker1, worker2, worker3);
        List<Job> expected = List.of(worker1, worker2, worker3);
        list.sort(new JobIncreaseByName().thenComparing(new JobDescByPriority()));
        assertEquals(expected, list);
    }

    @Test public void whenJobDescByNameAndDecreaseByPriority() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Alex", 0);
        Job worker3 = new Job("Irina", 2);
        Job worker4 = new Job("Pavel", 3);
        List<Job> list = Arrays.asList(worker1, worker2, worker3, worker4);
        List<Job> expected = List.of(worker4, worker3, worker1, worker2);
        list.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        assertEquals(expected, list);
    }

    @Test
    public void whenJobDecreaseByPriorityAndDecreaseByName() {
        Job worker1 = new Job("Alex", 1);
        Job worker2 = new Job("Alex", 2);
        Job worker3 = new Job("Irina", 2);
        Job worker4 = new Job("Pavel", 3);
        List<Job> list = Arrays.asList(worker1, worker2, worker3, worker4);
        List<Job> expected = List.of(worker4, worker3, worker2, worker1);
        list.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        assertEquals(expected, list);
    }
}