package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = add(
                    () -> {
                        int num = 0;
                            for (int value: number) {
                                num += value;
                        }
                        return num;
                    }
            );
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}