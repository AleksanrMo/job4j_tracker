package ru.job4j.collaction;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {

    public static HashSet<Account> sent(List<Account> accounts) {
       HashSet<Account> rsl = new HashSet<>();
       for (Account pack: accounts) {
           rsl.add(pack);
       }
       return rsl;
    }
}
