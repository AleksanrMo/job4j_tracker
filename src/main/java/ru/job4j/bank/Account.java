package ru.job4j.bank;

import java.util.Objects;

/**
 * Клас является моделью для создания клиетского аккаунта;
 * @author Job4j и MOKIN ALEKSANDR;
 * @version 1.0;
 */
public class Account {
    /**
     * Переменная requisite хранит реквизиты аккаунта.
     * Переменная balance хранит состояние счета на аккаунте.
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор для создания аккаута с реквизитами и балансом
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.balance =  balance;
        this.requisite = requisite;
    }

    /**
     * Метод позволяет отдельно изменить реквизиты.
     * @param requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     *
     * @return Метод возвращает реквизиты клиента.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет отдельно изменить баланс клиента.
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return Метод возвращает баланс клиента.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Переопределяем метод equals.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределям hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
