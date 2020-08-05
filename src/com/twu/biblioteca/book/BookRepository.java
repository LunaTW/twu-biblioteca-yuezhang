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
            new Book("04","Happy Coding","Luna","2468", Year.of(2020),"Laura"),
            new Book("05","Happy Reading","Luna","13579", Year.of(2020),"Dannie")
    ));

    public static List<Book> getAvailableBooks() {
        return availableBooks;
    }
    public static List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public BookRepository(List<Book> books){
    }

    public static void addBook(Book book) {
        availableBooks.add(book);
    }

    public static boolean judgment_checkOutBook(String title){
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

    public static boolean judgment_returnBook(String title){
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

    public static void displayBooks(){
        System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-11s%n","** Index **","|","** Title **","|", "** Author **","|", "** ISBN **", "|","** Year **");
        for (Book book: getAvailableBooks()){
            System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-12s%n", book.getindex(),"|",book.getTitle(), "|",
                    book.getAuthor(), "|", book.getIsbn(), "|", book.getYear());
        }
    }

    public static void checkOutBook(String bookName){
        String  input = bookName;
        System.out.println(judgment_checkOutBook(input)? "Thank you! Enjoy the book." : "Sorry, that book is not available.");
    }

    public static void returnBook(String bookName){
        String input = bookName;
        System.out.println(judgment_returnBook(input)? "Thanks for your return, have a good day!" : "This book may not borrowed from our library, please contact the librarian if not.");
    }

    public static void displayCheckOutBook(){
        System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-12s%-2s%-12s%n","** Index **","|","** Title **","|", "** Author **","|", "** ISBN **", "|","** Year **","|","** Borrowed **");
        for (Book book: getCheckedOutBooks()){
            System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-12s%-2s%-12s%n", book.getindex(),"|",book.getTitle(), "|",
                    book.getAuthor(), "|", book.getIsbn(), "|", book.getYear(),"|",book.getBorrowed());
        }
    }
}
