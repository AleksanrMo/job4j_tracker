package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

   public List<Address> collect(List<Profile> profiles) {
       return profiles.stream()
               .map(s -> s.getAddress())
               .sorted(new ComparePeople())
               .distinct()
               .collect(Collectors.toList());
    }
}

class ComparePeople implements Comparator<Address> {
    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}