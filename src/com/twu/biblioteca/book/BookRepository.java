package com.twu.biblioteca.book;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public static List<Book> availableBooks = new ArrayList<>(Arrays.asList(
            new Book("01","The little prince","Antoine de Saint-Exupery","9787539998312", Year.of(2017),"*"),
            new Book("02","And Then There were none","Agatha Christie","9780007136834",Year.of(2007),"*"),
            new Book("03","Harry Potter","Joanne Rowling","9573317249234",Year.of(2008),"*")
    ));
    public static List<Book> checkedOutBooks = new ArrayList<>(Arrays.asList(
            new Book("04","Happy Coding","Luna","2468", Year.of(2020),"*"),
            new Book("05","Happy Reading","Luna","13579", Year.of(2020),"*")
    ));

    public static List<Book> getAvailableBooks() {
        return availableBooks;
    }
    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public BookRepository(List<Book> books){
    }

    public static void addBook(Book book) {
        availableBooks.add(book);
    }

    public static boolean checkOutBook(String title){
        Book BookWouldLikeToCheckOut = availableBooks.stream().filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
        if ( BookWouldLikeToCheckOut != null){
            availableBooks.remove(BookWouldLikeToCheckOut);
            checkedOutBooks.add(BookWouldLikeToCheckOut);
            return true;
        } else {
            return false;
        }
    }

    public static boolean returnBook(String title){
        Book BookWouldLikeToReturn = checkedOutBooks.stream().filter(book -> book.getTitle().equals(title))
                .findFirst().orElse(null);
        if ( BookWouldLikeToReturn != null){
            checkedOutBooks.remove(BookWouldLikeToReturn);
            availableBooks.add(BookWouldLikeToReturn);
            return true;
        } else {
            return false;
        }
    }
}
