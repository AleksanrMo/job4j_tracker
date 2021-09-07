package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    public List<Integer> matrix(Integer[][] mat) {
        return Stream.of(mat)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
