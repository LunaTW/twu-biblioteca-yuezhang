package com.twu.biblioteca;

import com.sun.tools.javac.Main;
import com.twu.biblioteca.book.BookRepository;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.user.UserRepository;
import com.twu.biblioteca.welcome.WelcomeMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<String> options = new ArrayList<>(Arrays.asList(
                "View a list of books",
                "Checkout a book",
                "Return a book",
                "View a list of movies",
                "Checkout a movie",
                "Return a movie",
                "View books checked out",
                "View my information",
                "Quit"));
        BookRepository bookRepository = new BookRepository(BookRepository.availableBooks);
        MovieRepository movieRepository = new MovieRepository(MovieRepository.availableMovies);
        UserRepository userRepository = new UserRepository(UserRepository.availableUserInformations);

        WelcomeMessage.WelcomeMessageInScreen();
        MainMenu MainMenu = new MainMenu(options,bookRepository,movieRepository,userRepository);

        MainMenu.PrintAllMenuList();
        MainMenu.login();
    }
}
