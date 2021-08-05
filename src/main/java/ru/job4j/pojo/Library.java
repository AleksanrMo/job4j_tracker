package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book first = new Book("Курочка ряба", 12);
        Book second = new Book("Евгений Онегин", 150);
        Book third = new Book("Мартин Иден", 405);
        Book forth = new Book("Clean code", 120);
        Book[] array = new Book[4];
        array[0] = first;
        array[1] = second;
        array[2] = third;
        array[3] = forth;
        for (Book book: array) {
            System.out.println(book.getName() + " - " + book.getPages() + " страниц.");
        }
        System.out.println();
        Book temp;
        temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        for (Book book : array) {
            System.out.println(book.getName() + " - " + book.getPages() + " страниц.");
        }
        System.out.println();
        for (Book book: array) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}
