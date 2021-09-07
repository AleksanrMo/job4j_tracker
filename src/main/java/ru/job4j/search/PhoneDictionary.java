package ru.job4j.search;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Predicate;
public class PhoneDictionary {

  private ArrayList<Person> persons = new ArrayList<>();

  public void add(Person person) {

      this.persons.add(person);
  }

  public ArrayList<Person> find(String key) {
      Predicate<Person> perdName = el -> el.getName().contains(key);
      Predicate<Person> perdPhone = el -> el.getPhone().contains(key);
      Predicate<Person> perdSurname = el -> el.getSurname().contains(key);
      Predicate<Person> perdAdress = el -> el.getAddress().contains(key);
      Predicate<Person> combine = perdAdress.or(perdPhone).or(perdName).or(perdSurname);
      ArrayList<Person> result = new ArrayList<>();
      for (Person person : persons) {
          if (combine.test(person)) {
              result.add(person);
          }
      }
      return result;
  }
}
