package ru.job4j;

    public class Task {
        public static void loop(int num) {
            StringBuilder evenDigits = new StringBuilder();
            StringBuilder oddDigits = new StringBuilder();
            int number;
            while (num != 0) {
                number = num % 10;
                if (number % 2 == 0) {
                    evenDigits.append(number).append(" ");
                } else {
                    oddDigits.append(number).append(" ");
                }
                num /= 10;
            }
            if (!evenDigits.isEmpty()) {
                System.out.println(evenDigits.reverse().toString().trim());
            }
            if (!oddDigits.isEmpty()) {
                System.out.println(oddDigits.reverse().toString().trim());
            }
        }

        public static void main(String[] args) {
            loop(20);
        }
    }