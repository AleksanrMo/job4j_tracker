package ru.job4j.collaction;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int[] in: list) {
            for (int out: in) {
                result.add(count, out);
                        count++;
            }
        }
        return result;
    }
}
