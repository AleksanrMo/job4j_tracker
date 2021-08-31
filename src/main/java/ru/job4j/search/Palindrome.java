package ru.job4j.search;

public class Palindrome {

    public static boolean palindrome(String string) {
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - 1 - i]) {
               return   false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "anna anna anna";
        System.out.println(Palindrome.palindrome(string));
    }
}
