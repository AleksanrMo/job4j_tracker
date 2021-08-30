package ru.job4j.collaction;

    import java.util.Arrays;
    import java.util.Comparator;

    public class StringCompare implements Comparator<String> {
        @Override
        public int compare(String left, String right) {
           int rsl;
            int math = Math.min(left.length(), right.length());
            for (int i = 0; i < math; i++) {
               rsl = Character.compare(left.charAt(i), right.charAt(i));
               if (rsl != 0) {
                   return rsl;
               }
            }
           return Integer.compare(left.length(), right.length());
        }
    }



