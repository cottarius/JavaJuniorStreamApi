package task01;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        books.add(new Book("Анна Каренина", "Лев Толстой", 1877));

        for(Book book : books){
            if("Лев Толстой".equalsIgnoreCase(book.getAuthor())){
                System.out.println(book);
            }
        }
        System.out.println();
        for(Book book : books){
            if(book.getYear() >= 1866){
                System.out.println(book);
            }
        }
        System.out.println();
        List<String> uniqueTitles = new ArrayList<>();
        for (Book book : books){
            if (!uniqueTitles.contains(book.getTitle())){
                uniqueTitles.add(book.getTitle());
            }
        }
        System.out.println(uniqueTitles);
    }
}
