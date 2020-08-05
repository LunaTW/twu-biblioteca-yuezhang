

package com.twu.biblioteca.book;

import com.twu.biblioteca.MainMenu;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.user.UserRepository;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    Book book = new Book("06","New Book","Lunanana","12345", Year.of(2020),"*");
    BookRepository bookRepository = new BookRepository(BookRepository.availableBooks);
    MovieRepository movieRepository = new MovieRepository(MovieRepository.availableMovies);
    UserRepository userRepository = new UserRepository(UserRepository.availableUserInformations);
    private MainMenu mainMenu;
    private ByteArrayOutputStream MainMenuOutput;

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

    /*
    @Ignore
    @Test //Question: 这个测试单独跑没有问题，但一起跑的时候，会收到下面借还书的影响，这个应该如何解决
    public void ViewBooksCheckedOut(){
        mainMenu = new MainMenu(new ArrayList<>(Arrays.asList("View books checked out")),bookRepository,movieRepository,userRepository);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        mainMenu.UserSelectOptions();
        assertEquals("** Index **| ** Title **                   | ** Author **                  | ** ISBN **     | ** Year **  \n" +
                        "04         | Happy Coding                  | Luna                          | 2468           | 2020        \n" +
                        "05         | Happy Reading                 | Luna                          | 13579          | 2020        \n"+
                        "------------------------------------------------------\n" +
                        "What would you like to do?\n"+
                        "Enter 1 : View books checked out\n"
                , MainMenuOutput.toString());
    }
    */
}