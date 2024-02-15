package ru.job4j.checkstyle;

public class Broken {

    private static final String NEWVALUE = "";

    private int sizeOfEmpty = 10;

    private String name;

    private String surname;

    public Broken() {
    }

    public void echo() {
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }
}