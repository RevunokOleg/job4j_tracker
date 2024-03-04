package ru.job4j.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Поехали по рельсам!");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " Прибыли на станцию!");
    }
}
