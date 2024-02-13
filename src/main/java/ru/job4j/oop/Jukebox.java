package ru.job4j.oop;

public class Jukebox {

    void music(int position) {
        switch (position) {
            case 1:
                System.out.println("Пусть бегут неуклюже");
                break;
            case 2:
                System.out.println("Спокойной ночи");
                break;
            default:
                System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox song = new Jukebox();
        int position = 1;
        song.music(position);
        position = 2;
        song.music(position);
        song.music(3);
    }
}
