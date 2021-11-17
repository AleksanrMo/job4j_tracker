package ru.job4j.test;

import java.util.*;
import java.util.Comparator;

public class Sorting {
    public static void main(String[] args) {
        List<They> human = Arrays.asList(new They("Alex", "Builder", 24),
                new They("Boris", "Farmer", 65),
                new They("Yana", "Mom", 65));
       human.sort(new PersonComparator().thenComparing(new PersonComparato()));
        System.out.println(human);
    }

    public static class They {

        private String name;
        private String work;
        private int age;

        public They(String name, String work, int age) {
            this.name = name;
            this.work = work;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getWork() {
            return work;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            They they = (They) o;
            return age == they.age && Objects.equals(name, they.name)
                    && Objects.equals(work, they.work);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, work, age);
        }

        @Override
        public String toString() {
            return "They{"
                    +
                    "name='" + name + '\''
                    +
                    ", work='" + work + '\''
                    +
                    ", age=" + age
                    +
                    '}';
        }
    }
}

class PersonComparator implements Comparator<Sorting.They> {
    public int compare(Sorting.They a, Sorting.They b) {
        return Integer.compare(a.getAge(), b.getAge());
    }
}

class PersonComparato implements Comparator<Sorting.They> {
    public int compare(Sorting.They a, Sorting.They b) {
        return a.getName().compareTo(b.getName());
    }
}