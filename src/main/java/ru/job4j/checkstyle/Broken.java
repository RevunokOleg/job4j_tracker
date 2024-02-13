package ru.job4j.checkstyle;

public class Broken {

    public static final String NEWVALUE = "";

    public String surname;

    String name;

    private final int sizeOfEmpty = 10;

    Broken() {
    }

    void echo() {
    }

    void method(int a, int b, int c, int d, int e, int f, int g) {
    }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }
}