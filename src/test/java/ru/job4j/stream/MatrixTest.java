package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MatrixTest {

    @Test
    public void testOfMatrix() {
        Integer[][] numbers = {{1, 2, 3}, {4, 5, 6}};
        Matrix test = new Matrix();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> rsl = test.matrix(numbers);
        assertThat(expected, is(rsl));

    }
}