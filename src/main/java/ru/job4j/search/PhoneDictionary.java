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
      Predicate<Person> predName = el -> el.getName().contains(key);
      Predicate<Person> predPhone = el -> el.getPhone().contains(key);
      Predicate<Person> predSurname = el -> el.getSurname().contains(key);
      Predicate<Person> predAdress = el -> el.getAddress().contains(key);
      Predicate<Person> combine = predAdress.or(predPhone).or(predName).or(predSurname);
      ArrayList<Person> result = new ArrayList<>();
      for (Person person : persons) {
          if (combine.test(person)) {
              result.add(person);
          }
      }
      return result;
  }
}
