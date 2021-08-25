package ru.job4j.collaction;

import java.util.Objects;

public class Order {

   private String name;
   private String number;

   public Order(String number, String name) {
       this.name = name;
       this.number = number;
   }

  public String getNumber() {
       return number;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(name, order.name) && Objects.equals(number, order.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Order{"
                +
                "name='" + name + '\''
                +
                ", number='" + number + '\''
                +
                '}';
    }
}
