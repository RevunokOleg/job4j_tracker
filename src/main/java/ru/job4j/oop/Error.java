package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void showInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error object = new Error();
        Error objOne = new Error(true, 1, "objectOne Error");
        Error objTwo = new Error(true, 1, "objectTwo Error");
        Error objThree = new Error(false, 2, "objectThree not Error");
        object.showInfo();
        objOne.showInfo();
        objTwo.showInfo();
        objThree.showInfo();
    }
}
