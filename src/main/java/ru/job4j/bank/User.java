package ru.job4j.bank;

import java.util.Objects;

/**
 *В данном классе реализована модель пользователя банка.
 * Эта модель содержит поля: номер паспорта и ФИО.
 * @author Revunok Oleg
 * @version 1.0
 */
public class User {

    /**
     * Переменная хранит паспорт потльзователя.
     */
    private String passport;

    /**
     * Переменная хранит имя пользователя.
     */
    private String username;

    /**
     * Конструктор объекта User.
     * @param passport паспорт пользователя.
     * @param username имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод получения паспортных данных.
     * @return возвращает паспортные данные.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает паспортные данные.
     * @param passport паспорт пользователя.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод получения имени пользователя.
     * @return возврщает имя пользоваетеля.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает имя пользователя.
     * @param username имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хэш-код объекта на основе его паспорта.
     * @return возвращает хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}