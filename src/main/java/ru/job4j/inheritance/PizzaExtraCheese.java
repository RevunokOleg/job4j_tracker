package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    private static final String WITH_CHEESE = " + extra cheese";

    public String name() {
        return super.name() + WITH_CHEESE;
    }
}
