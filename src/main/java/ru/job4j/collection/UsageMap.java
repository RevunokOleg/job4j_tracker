package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("revunokoleg@gmail.com", "Vasiliy Petrov");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("revunokoleg@gmail.com", "Revunok Oleg Alekseevich");
        map.put("ivanov@gmail.com", "Ivan Ivanov");
        map.put("stepanov@gmail.com", "Stepan Stepanov");
        map.put("revunokoleg@gmail.com", "Revunok Oleg");
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
