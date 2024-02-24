package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 100);
        Book book2 = new Book("Колобок", 200);
        Book book3 = new Book("Три поросенка", 300);
        Book book4 = new Book("Винни Пух", 400);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book : books) {
            System.out.println("Книга " + book.getBookName() + " состоит из " + book.getPageCount() + " страниц");
        }
        System.out.println("\nМеняем местами книги Clean code и Винни Пух");
        books[0] = book4;
        books[3] = book1;
        System.out.println();
        for (Book book : books) {
            System.out.println("Книга " + book.getBookName() + " состоит из " + book.getPageCount() + " страниц");
        }
        System.out.println("\nВыводим только книги с именем Clean code\n");
        for (Book book : books) {
            if ("Clean code".equals(book.getBookName())) {
                System.out.println("Книга " + book.getBookName() + " состоит из " + book.getPageCount() + " страниц");
            }
        }
    }
}
