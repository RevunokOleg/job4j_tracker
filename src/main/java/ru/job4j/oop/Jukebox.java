package ru.job4j.oop;

public class Jukebox {

    void music(int position) {
        String value = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(value);
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
