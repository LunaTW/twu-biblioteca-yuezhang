package com.twu.biblioteca;

import com.twu.biblioteca.book.BookRepository;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.user.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MainMenu {
    private List<String> options;
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private Scanner scanner;
    private String bookName;
    private String movieName;
    private String UserID;
    private String password;
    private String UserSelectedOption;

    public MainMenu(List<String> options, BookRepository bookRepository, MovieRepository movieRepository, UserRepository userRepository){
        this.options = options;
        this.bookRepository=bookRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public void PrintAllMenuList(){
        System.out.println("What would you like to do?");
        IntStream.range(0, options.size()).forEach(i -> System.out.println("Enter "+ (i + 1) + " : " + options.get(i)));
    }

    //检查输入项是否有效
    //1. 有输入 2. 是个数字 3. 数字在选项的list中
    private boolean CheckInputIsValid(String option){
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

    public void UserSelectOptions() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) { // User's choice, otherwise waiting
            UserSelectedOption = scanner.nextLine();
            if (CheckInputIsValid(UserSelectedOption)) {
                System.out.println("Success");

            } else {
                System.out.println("------------------------------------------------------");
                System.out.println("Please try again!");
                UserSelectOptions();
            }
        }

    }
}

