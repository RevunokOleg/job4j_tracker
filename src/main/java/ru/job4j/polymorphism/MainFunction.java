package ru.job4j.polymorphism;

public class MainFunction implements FunctionOne, FunctionTwo {

    @Override
    public double function(double x, double y) {
        return FunctionTwo.super.function(x, y);
    }

    public static void main(String[] args) {
        FunctionTwo functionTwo = new MainFunction();
        System.out.println(functionTwo.function(2, 5.4));
    }
}
