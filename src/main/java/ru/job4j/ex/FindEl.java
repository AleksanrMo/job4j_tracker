package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Not found key in this array.");
        }
        return  rsl;
    }

    public static void main(String[] args)  {
       try {
        String[] str = {"one", "two", "three"};
        indexOf(str, "three");
       } catch (ElementNotFoundException e) {
           e.printStackTrace();

       }
    }
}
