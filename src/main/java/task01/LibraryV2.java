package task01;

import java.util.ArrayList;
import java.util.List;

public class LibraryV2 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));


        books
                .stream()
                .filter(book -> "Лев Толстой".equals(book.getAuthor()))
                .forEach(System.out::println);

        System.out.println();

        books
                .stream()
                .filter(year -> year.getYear() > 1866)
                .forEach(System.out::println);
        System.out.println();
        books
                .stream()
                .map(Book::getTitle)
                .distinct()
                .forEach(System.out::println);
    }
}
