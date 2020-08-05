

package com.twu.biblioteca.book;

import org.junit.Test;
import java.time.Year;
import static org.junit.Assert.*;

public class BookRepositoryTest {
    Book book = new Book("06","New Book","Lunanana","12345", Year.of(2020),"*");

    @Test
    public void BookCanBeAddedInBOOKLIST(){
        assertEquals(BookRepository.availableBooks.stream().filter(book -> book.getTitle().equals("New Book")).findFirst().orElse(null),null);
        BookRepository.availableBooks.add(book);
        assertNotEquals(BookRepository.availableBooks.stream().filter(book -> book.getTitle().equals("New Book")).findFirst().orElse(null),null);
    }

    @Test
    public void BookCanBeReturnBOOKLIST(){
        BookRepository.availableBooks.add(book);
        assertTrue(BookRepository.getAvailableBooks().contains(book));
    }

    @Test
    public void AvailableBookCanBeCheckOutBOOKLIST(){
        assertTrue(BookRepository.judgment_checkOutBook("The little prince"));
        assertFalse(BookRepository.judgment_checkOutBook("WrongBook"));
    }

    @Test
    public void AvailableBookCanBeReturnBOOKLIST(){
        assertTrue(BookRepository.judgment_returnBook("Happy Coding"));
        assertFalse(BookRepository.judgment_returnBook("WrongBook"));
    }

}