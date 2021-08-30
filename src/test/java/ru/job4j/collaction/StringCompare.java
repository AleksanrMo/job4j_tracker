package ru.job4j.collaction;

    import java.util.Comparator;

    public class StringCompare implements Comparator<String> {
        @Override
        public int compare(String left, String right) {
            char[] chArray = left.toCharArray();
            char[] chArray2 = right.toCharArray();
            int rsl = 0;
            for (char c : chArray) {
                for (char value : chArray2) {
                    if (c > value) {
                        return   1;
                    } else if (c < value) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
           return 0;
        }
    }

