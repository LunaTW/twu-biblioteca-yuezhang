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
        System.out.println("Please input your Password: ");
        password = scanner.nextLine();
        //System.out.println("Please click return");
        //UserSelectedOption = scanner.nextLine();
        if(UserID == "\n"  ){
            System.out.println("UserID cannot be empty!");
            login();
        }
        if(password =="\n" ){
            System.out.println("UserID cannot be empty!");
            login();
        }

        if (UserRepository.areValidCredentials(UserID,password)){
            System.out.println("UserID : "+ UserID+"\n"+
                    "Successful login\n------------------------------------------------------");
            LoginID_Now = UserID;
            PrintAllMenuList();
            UserSelectOptions();
        }else{
            System.out.println("Sorry that's not a valid ID/PASSWORD");
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
                        displayBooks();
                        break;
                    case "Checkout a book":
                        System.out.println("Which book would you like to checkout?[Please input BOOK NAME]");
                        bookName = scanner.nextLine();
                        checkOutBook(bookName);
                        break;
                    case "Return a book":
                        System.out.println("Which book would you like to Return?[Please input BOOK NAME]");
                        bookName = scanner.nextLine();
                        returnBook(bookName);
                        break;
                    case "View a list of movies":
                        displayMovies();
                        break;
                    case "Checkout a movie":
                        System.out.println("Which movie would you like to checkout?[Please input MOVIE NAME]");
                        movieName = scanner.nextLine();
                        checkOutMovie(movieName);
                        break;
                    case "Return a movie":
                        System.out.println("Which movie would you like to Return?[Please input MOVIE NAME]");
                        movieName = scanner.nextLine();
                        returnMovie(movieName);
                        break;
                    case "View books checked out":
                        displayCheckOutBook();
                        break;
                    case "View my information":
                        ViewMyInformation(LoginID_Now);
                        break;
                    case "Quit":
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("------------------------------------------------------");
                System.out.println("Please try again!");
                UserSelectOptions();
            }
        }

    }


    //************************************* Function ********************************//
    private static void displayBooks(){
        System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-11s%-2s%-12s%n","** Index **","|","** Title **","|", "** Author **","|", "** ISBN **", "|","** Year **","|","** Borrowed **");
        for (Book book: bookRepository.getAvailableBooks()){
            System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-12s%-2s%-12s%n", book.getindex(),"|",book.getTitle(), "|",
                    book.getAuthor(), "|", book.getIsbn(), "|", book.getYear(),"|",book.getBorrowed());
        }
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }


    private static void checkOutBook(String bookName){
        String  input = bookName;
        System.out.println(bookRepository.checkOutBook(input)? "Thank you! Enjoy the book." : "Sorry, that book is not available.");
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }

    private static void returnBook(String bookName){
        String input = bookName;
        System.out.println(bookRepository.returnBook(input)? "Thanks for your return, have a good day!" : "This book may not borrowed from our library, please contact the librarian if not.");
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }

    private static void displayCheckOutBook(){
        System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-11s%-2s%-12s%n","** Index **","|","** Title **","|", "** Author **","|", "** ISBN **", "|","** Year **","|","** Borrowed **");
        for (Book book: bookRepository.getCheckedOutBooks()){
            System.out.printf("%-11s%-2s%-30s%-2s%-30s%-2s%-15s%-2s%-12s%-2s%-12s%n", book.getindex(),"|",book.getTitle(), "|",
                    book.getAuthor(), "|", book.getIsbn(), "|", book.getYear(),"|",book.getBorrowed());
        }
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }

    private static void displayMovies(){
        System.out.printf("%-30s%-2s%-30s%-2s%-6s%n","** Title **","|", "** Director **","|","** Year **");
        for(Movie movie:movieRepository.getAvailableMovies()){
            System.out.printf("%-30s%-2s%-30s%-2s%-6s%n", movie.getTitle(),"|",movie.getDirector(),"|",movie.getYear());
        }
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }

    private static void checkOutMovie(String movieName){
        String input = movieName;
        System.out.println(movieRepository.checkOutMovie(input)? "Thank you! Enjoy the movie." : "Sorry, that movie is not available.");
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }

    private static void returnMovie(String movieName){
        String input = movieName;
        System.out.println(movieRepository.returnMovie(input)? "Thanks for your return, have a good day" : "This movie may not borrowed from our library, please contact the librarian if not.");
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }

    private static void ViewMyInformation(String userID) {
        System.out.printf("%-13s%-2s%-15s%-2s%-19s%-2s%-16s%n","** UserID **","|","** UserName **","|", "** PassWord **","|", "** Email **");
        User USER = UserRepository.getUser(userID);
        System.out.printf("%-13s%-2s%-15s%-2s%-19s%-2s%-16s%n", USER.getUserID(),"|",USER.getUserName(), "|",
                USER.getPassword(), "|", USER.getEmail());
        System.out.println("------------------------------------------------------");
        PrintAllMenuList();
        UserSelectOptions();
    }
}

