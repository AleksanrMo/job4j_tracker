package ru.job4j.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return  students.stream()
               .filter(predict)
               .collect(Collectors.toList());
    }

    public Map<String, Integer> change(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname,
                        Student::getScore, (existing, replacement) -> existing));
    }
}
