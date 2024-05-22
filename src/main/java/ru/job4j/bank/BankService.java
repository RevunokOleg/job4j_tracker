package ru.job4j.bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * В данном классе реализована модель для банковской системы.
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет.
 * У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Revunok Oleg
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение данных осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в коллекцию, если его там нет.
     * @param user пользователь, добавляемый в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из коллекции.
     * @param passport паспорт удаляемого пользователя.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет пользователю новый счет при условии,
     * что пользователь существует и у него еще нет такого счета.
     * @param passport паспорт пользователя.
     * @param account счет пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport паспорт пользователя.
     * @return возвращает пользователя, если он найдет,
     * либо null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет в списке счетов по реквизитам.
     * @param passport паспорт пользователя.
     * @param requisite реквизиты счета.
     * @return возвращает счет, если он найден, либо
     * null, если счет не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод перечисляет деньги с одного счета на другой.
     * @param sourcePassport паспорт владельца счета, с которого переводят.
     * @param sourceRequisite реквизиты счета, с которого переводят.
     * @param destinationPassport паспорт владельца счета, на который переводят.
     * @param destinationRequisite реквизиты счета, на который переводят.
     * @param amount сумма перевода.
     * @return возвращает true, если перевод осуществлен, либо false,
     * если не хватает денег на счёте, с которого переводят, либо счёт не найден.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && sourceAccount.getBalance() >= amount && destinationAccount != null) {
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод позволяет получить список счетов пользователя.
     * @param user пользователь.
     * @return возвращает список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}