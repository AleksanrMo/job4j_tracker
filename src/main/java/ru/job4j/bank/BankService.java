package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

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
     *
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
     *
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход номер паспрта клиента.
     * Переберает циклом клиентов сравнивая их номера паспорта с  passport.
     * Возвращает клиента по паспорту если такой имеется в базе.
     *
     * @param passport
     * @return Возвращает клиента по паспорту если такой имеется в базе.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();

    }

    /**
     * Метод принимает на вход паспорот и реквизиты.
     * По паспорту находим клиента.
     * Если такой имеется то ищем есть ли такой аккаунт с определенными реквизитами.
     *
     * @param passport
     * @param requisite
     * @return Возвращает аккаунт клиента.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst();
        }
        return null;
    }

        /**
         * Метод принимает на вход паспорта и реквезиты двух аккаунтов
         * и количество средств для преревода.
         * Осуществляет преревод с первого  счета на другой
         * если на первом хватает средств для преревода
         * @return Возвращает результат опереции в виде true или false.
         * @param srcPassport
         * @param srcRequisite
         * @param destPassport
         * @param destRequisite
         * @param amount
         *
         */
        public boolean transferMoney(String srcPassport, String srcRequisite,
                                     String destPassport, String destRequisite,
                                     double amount) {
            boolean rsl = false;
            Optional<Account> firstAccount = findByRequisite(srcPassport, srcRequisite);
            Optional<Account> secondAccount = findByRequisite(destPassport, destRequisite);
                if (firstAccount.isPresent() && secondAccount.isPresent()
                        && firstAccount.get().getBalance() >= amount) {
                    firstAccount.get().setBalance(firstAccount.get().getBalance() - amount);
                    secondAccount.get().setBalance(secondAccount.get().getBalance() + amount);
                rsl = true;
            }
            return rsl;
        }
    }

