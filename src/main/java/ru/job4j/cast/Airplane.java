package ru.job4j.cast;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Полетели!");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " Приземлились!");
    }
}
