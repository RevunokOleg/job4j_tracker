package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item itemDate = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = itemDate.getCreated().format(formatter);
        System.out.println(currentDateTimeFormat);
        Item newDate = new Item();
        System.out.println(newDate);
    }
}
