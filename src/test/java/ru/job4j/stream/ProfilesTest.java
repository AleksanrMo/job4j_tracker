package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {

    @Test
    public void whenAddElement() {
        Profiles test = new Profiles();
        List<Profile> puzzle = Arrays.asList(new Profile(
                new Address("Barnaul", "Lenina", 43, 54)));
        List<Address> expected = List.of(new Address(
                "Barnaul", "Lenina", 43, 54));
        assertThat(test.collect(puzzle), is(expected));
    }

    @Test
    public void whenAdd2Elements() {
        Profiles test = new Profiles();
        List<Profile> list = Arrays.asList(new Profile(
                new Address("Barnaul", "Lenina", 43, 54)),
               new Profile(new Address("Novosibirsk", "Pushkina", 12, 128)));
        List<Address> expected = List.of(new Address(
                "Barnaul", "Lenina", 43, 54),
                new Address("Novosibirsk", "Pushkina", 12, 128));
        assertThat(test.collect(list), is(expected));
    }

    @Test
    public void whenAdd2Elements3() {
        Profiles test = new Profiles();
        List<Profile> list = Arrays.asList(new Profile(
                        new Address("Barnaul", "Lenina", 43, 54)),
                new Profile(new Address("Novosibirsk", "Pushkina", 12, 128)),
                new Profile(new Address("Barnaul", "Nikinina", 1, 23)),
        new Profile(new Address("Barnaul", "Lenina", 43, 54)));
        List<Address> expected = List.of(new Address(
                        "Barnaul", "Lenina", 43, 54),
                new Address("Barnaul", "Nikinina", 1, 23),
                new Address("Novosibirsk", "Pushkina", 12, 128));
        assertThat(test.collect(list), is(expected));
    }
}