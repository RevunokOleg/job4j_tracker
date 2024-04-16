package ru.job4j;

    public class Task {
        public static void loop(int num) {
            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
            int number;
            while (num != 0) {
                number = num % 10;
                if (number % 2 == 0) {
                    result1.append(number).append(" ");
                } else {
                    result2.append(number).append(" ");
                }
                num /= 10;
            }
            if (!(result1.isEmpty())) {
                System.out.println(result1.reverse().toString().trim());
            }
            if (!(result2.isEmpty())) {
                System.out.println(result2.reverse().toString().trim());
            }
        }

        public static void main(String[] args) {
            loop(20);
        }
    }