package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int sizeResult = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                result[sizeResult++] = items[i];
            }
        }
        return Arrays.copyOf(result, sizeResult);
    }

    public Item findById(int id) {
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                return items[index];
            }
        }
        return null;
    }
}