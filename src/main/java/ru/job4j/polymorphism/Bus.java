package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("На борту " + count + " пассажиров");
    }

    @Override
    public double refill(double liter) {
        double cost = 100;
        return liter * cost;
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.drive();
        bus.passengers(10);
        System.out.println("Стоимость заправки " + bus.refill(50));
    }
}