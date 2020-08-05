package com.twu.biblioteca;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookRepository;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class MainMenu {
    private static List<String> options;
    private static BookRepository bookRepository;
    private static MovieRepository movieRepository;
    private static UserRepository userRepository;
    private Scanner scanner;
    private static String bookName;
    private static String movieName;
    private String UserID;
    private String password;
    private static String UserSelectedOption;
    public static String LoginID_Now;

    public MainMenu(List<String> options, BookRepository bookRepository, MovieRepository movieRepository, UserRepository userRepository){
        this.options = options;
        this.bookRepository=bookRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }


    public static void PrintAllMenuList(){
        System.out.println("What would you like to do?");
        IntStream.range(0, options.size()).forEach(i -> System.out.println("Enter "+ (i + 1) + " : " + options.get(i)));
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your UserID: ");
        UserID = scanner.nextLine();
        if(UserRepository.getUser(UserID) == null){
            System.out.println("This is not a valid UserID, please try again! ");
            login();
        }
        System.out.println("Please input your Password: ");
        password = scanner.nextLine();
        if (UserRepository.areValidCredentials(UserID,password)){
            System.out.println("UserID : "+ UserID+"\n"+
                    "Successful login\n------------------------------------------------------");
            LoginID_Now = UserID;
            PrintAllMenuList();
            UserSelectOptions();
        }else{
            System.out.println("Sorry that's not a correct PASSWORD, please again! ");
            login();
        }
    }

    //检查输入项是否有效
    //1. 有输入 2. 是个数字 3. 数字在选项的list中
    private static boolean CheckInputIsValid(String option){
        int InputNumber;
        try {
            InputNumber = Integer.valueOf(option);
        }
        catch(NumberFormatException e){
            System.out.println("Please select a valid option");
            return false;
        }
        if (InputNumber <= 0 || InputNumber > options.size()){
            System.out.println("Please select a valid option");
            return false;
        }
        return true;
    }

    public static void UserSelectOptions() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) { // User's choice, otherwise waiting
            UserSelectedOption = scanner.nextLine();
            if (CheckInputIsValid(UserSelectedOption)) {
                String optionChoice = options.get(Integer.valueOf(UserSelectedOption) - 1); //index 比本身小1
                switch (optionChoice){
                    case "View a list of books":
                        bookRepository.displayBooks();
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "Checkout a book":
                        System.out.println("Which book would you like to checkout?[Please input BOOK NAME]");
                        bookName = scanner.nextLine();
                        bookRepository.checkOutBook(bookName);
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "Return a book":
                        System.out.println("Which book would you like to Return?[Please input BOOK NAME]");
                        bookName = scanner.nextLine();
                        bookRepository.returnBook(bookName);
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "View books checked out":
                        bookRepository.displayCheckOutBook();
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "View a list of movies":
                        movieRepository.displayMovies();
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "Checkout a movie":
                        System.out.println("Which movie would you like to checkout?[Please input MOVIE NAME]");
                        movieName = scanner.nextLine();
                        movieRepository.checkOutMovie(movieName);
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "Return a movie":
                        System.out.println("Which movie would you like to Return?[Please input MOVIE NAME]");
                        movieName = scanner.nextLine();
                        movieRepository.returnMovie(movieName);
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "View my information":
                        UserRepository.ViewMyInformation(LoginID_Now);
                        System.out.println("------------------------------------------------------");
                        PrintAllMenuList();
                        UserSelectOptions();
                        break;
                    case "Quit":
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("------------------------------------------------------");
                PrintAllMenuList();
                UserSelectOptions();
            }
        }

    }
}

