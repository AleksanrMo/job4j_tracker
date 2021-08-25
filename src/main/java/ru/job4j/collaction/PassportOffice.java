package ru.job4j.collaction;

import java.util.HashMap;

public class PassportOffice {

    private HashMap<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (citizens.containsKey(citizen)) {
            return true;
        }
        citizens.put(citizen.getPassport(), citizen);
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}