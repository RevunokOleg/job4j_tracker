package ru.job4j.cast;

public class VehicleMain {

    public static void main(String[] args) {
        Vehicle airplaneOne = new Airplane();
        Vehicle airplaneTwo = new Airplane();
        Vehicle trainOne = new Train();
        Vehicle trainTwo = new Train();
        Vehicle busOne = new Bus();
        Vehicle busTwo = new Bus();
        Vehicle[] vehicles = new Vehicle[] {airplaneOne, airplaneTwo, trainOne, trainTwo, busOne, busTwo};
        for (Vehicle transport : vehicles) {
            transport.move();
            transport.stop();
        }
    }
}
