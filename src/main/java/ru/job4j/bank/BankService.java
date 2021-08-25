package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

   private Map<User, List<Account>> users = new HashMap<>();

   public void addUser(User user) {
       if (!users.containsKey(user)) {
           users.put(user, new ArrayList<>());
       }
   }

   public void addAccount(String passport, Account account) {
     User alex = new User(" ", " ");
     alex = findByPassport(passport);
      users.put(findByPassport(passport), new ArrayList<Account>().add(account));

   }

   public User findByPassport(String passport) {
        User user = new User(" ", " ");
       for (User key: users.keySet()) {
          if (key.getPassport().equals(passport)) {
             user =  key;
             break;
           }

       }
       return user;
   }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}
