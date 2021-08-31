package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс описывает методы для работы банковского сервиса по добавлению клиентов в базу,
 * созданию новых счетов, переводов средст между счетами.
 * @author Job4j и MOKIN ALEKSANDR
 * @version 1.0
 */
public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход объект класса User и  добавляет его в HashMap users.
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает два параметра - паспорт и объект класса Account.
     * Находим клиента по номеру паспорта и получаем все его существующе аккауны в список.
     * Сравниваем принятый объект с существующими аккаунтами ,
     * если такого нет то добавляем его в список.
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспрта клиента.
     * Переберает циклом клиентов сравнивая их номера паспорта с  passport.
     * Возвращает клиента по паспорту если такой имеется в базе.
     * @return Возвращает клиента по паспорту если такой имеется в базе.
     * @param passport
     *
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User key: users.keySet()) {
            if (key.getPassport().equals(passport)) {
                user =  key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод принимает на вход паспорот и реквизиты.
     * По паспорту находим клиента.
     * Если такой имеется то ищем есть ли такой аккаунт с определенными реквизитами.
     * @return Возвращает аккаунт клиента.
     * @param passport
     * @param requisite
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null)  {
            List<Account> list = users.get(user);
            for (Account account: list) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорта и реквезиты двух аккаунтов
     * и количество средств для преревода.
     * Осуществляет преревод с первого  счета на другой если на первом хватает средств для преревода
     * @return Возвращает результат опереции в виде true или false.
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     *
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if (account1 != null && account2 != null && account1.getBalance() >= amount) {
            account1.setBalance(account1.getBalance() - amount);
            account2.setBalance(account2.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
