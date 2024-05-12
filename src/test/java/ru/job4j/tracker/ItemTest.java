package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void whenAscByName() {
        List<Item> items = Arrays.asList(
                new Item(4, "Reboot server"),
                new Item(1, "Fix bugs"),
                new Item(2, "Impl task")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Fix bugs"),
                new Item(2, "Impl task"),
                new Item(4, "Reboot server")
        );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenDescByName() {
        List<Item> items = Arrays.asList(
                new Item(4, "Reboot server"),
                new Item(1, "Fix bugs"),
                new Item(2, "Impl task")
        );
        List<Item> expected = Arrays.asList(
                new Item(4, "Reboot server"),
                new Item(2, "Impl task"),
                new Item(1, "Fix bugs")                               
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}
