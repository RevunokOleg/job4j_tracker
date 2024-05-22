package ru.job4j.bank;

import java.util.Objects;

/**
 * В данном классе реализована модель банковского счета.
 * Эта модель содержит поля: баланс и реквизиты.
 * @author Revunok Oleg
 * @version 1.0
 */
public class Account {

    /**
     * Переменная хранит реквизиты счета.
     */
    private String requisite;

    /**
     * Переменная хранит баланс счета.
     */
    private double balance;

    /**
     * Конструктор объекта Account.
     * @param requisite реквизиты счета.
     * @param balance баланс счета.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод получения реквизитов счета.
     * @return возвращет реквизиты счета.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает реквизиты счета.
     * @param requisite реквизиты счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод получения баланса счета.
     * @return возвращает баланс счета.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает баланс счета .
     * @param balance баланс счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнения двух объектов.
     * @param o объект сравнения.
     * @return возвращет true, если объекты равны,
     * либо false, если не равны.
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
     * Метод возвращает хэш-код объекта на основе его реквизитов.
     * @return возвращает хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}