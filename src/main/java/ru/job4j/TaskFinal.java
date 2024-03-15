package ru.job4j;

public class TaskFinal {

    public static void transform(int number) {
        int digit;
        int transformedDigit;
        int transformedNumber = 0;
        int numberAbs = Math.abs(number);
        int numberLength = (int) Math.log10(numberAbs) + 1;
        for (int i = 0; i < numberLength; i++) {
            digit = (int) (numberAbs / Math.pow(10, i) % 10);
            if (even(numberAbs)) {
                transformedDigit = even(digit) ? digit + 1 : digit - 1;
            } else {
                transformedDigit = even(digit) && digit != 0 ? digit - 1 : !even(digit) && digit != 9 ? digit + 1 : digit;
            }
            transformedNumber += (int) (transformedDigit * Math.pow(10, i));
        }
        if (number < 0) {
            transformedNumber *= -1;
        }
        System.out.println(transformedNumber);
    }

    public static boolean even(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        transform(390);
        transform(333);
        transform(-900);
        transform(999);
        transform(-109);
        transform(100);
    }
}