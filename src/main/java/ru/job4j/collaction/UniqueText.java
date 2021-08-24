package ru.job4j.collaction;

import java.util.HashSet;
import java.util.Locale;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        HashSet<String> check = new HashSet<>();
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        for (String original : origin) {
            check.add(original);
        }
        for (String check2 : duplicate) {
            if (!check.contains(check2)) {
                return false;
            }
        }
        return rsl;
    }
}