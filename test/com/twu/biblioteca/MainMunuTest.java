package com.twu.biblioteca;

import com.twu.biblioteca.book.BookRepository;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.user.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MainMunuTest {
    private List<String> options;
    private MainMenu mainMenu;
    private ByteArrayOutputStream MainMenuOutput;
    private String InvalidOption = "Please select a valid option";
    private static String option1="View a list of books";
    private static String option2 = "Checkout a book";
    private static String option3 = "Return a book";
    private static String option4 = "View a list of movies";
    private static String option5 = "Checkout a movie";
    private static String option6 = "Return a movie";
    private static String option7 = "Login";
    private static String option8 = "View books checked out";
    private static String option9 = "View my information";
    private static String option10 = "Quit";
    BookRepository bookRepository = new BookRepository(BookRepository.availableBooks);
    MovieRepository movieRepository = new MovieRepository(MovieRepository.availableMovies);
    UserRepository userRepository = new UserRepository(UserRepository.availableUserInformations);

    //****************************  (1.4) View main menu of options ****************************** //
    @Test
    public void MainMenuWasPrintedWhenZeroOption(){
        options = new ArrayList<>(Arrays.asList());
        mainMenu = new MainMenu(options,null,null,null);
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        mainMenu.PrintAllMenuList();
        assertEquals("What would you like to do?\n", MainMenuOutput.toString());
    }

    @Test
    public void MainMenuWasPrintedWhenOneOption(){
        options = new ArrayList<>(Arrays.asList(option1));
        mainMenu = new MainMenu(options,null,null,null);
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        mainMenu.PrintAllMenuList();
        assertEquals("What would you like to do?\nEnter 1 : " + option1 + "\n", MainMenuOutput.toString());
    }

    //*********************************** 1.5 当我选择无效选项时得到通知 *********************************** //
    @Test //此时只有一个option,只有 1 是正确的，其他如 100，list，-8，3.5 均无效
    public void GetNotifiedWhenChoseInvalidOption_OtherNumber_Decimal_NegativeNumber_NonNumber(){
        options = new ArrayList<>(Arrays.asList(option1));
        mainMenu = new MainMenu(options,null,null,null);

        // 测试超过选择的正整数不能通过
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        System.setIn(new ByteArrayInputStream("100".getBytes()));
        mainMenu.UserSelectOptions();
        assertEquals(InvalidOption + "\n"+
                "------------------------------------------------------\n"+
                "Please try again!\n"
                , MainMenuOutput.toString());

        // 测试小数不能通过验证
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        System.setIn(new ByteArrayInputStream("2.5".getBytes()));
        mainMenu.UserSelectOptions();
        assertEquals(InvalidOption + "\n"+
                        "------------------------------------------------------\n"+
                        "Please try again!\n"
                , MainMenuOutput.toString());

        // 测试负数不能通过验证
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        System.setIn(new ByteArrayInputStream("-3".getBytes()));
        mainMenu.UserSelectOptions();
        assertEquals(InvalidOption + "\n"+
                        "------------------------------------------------------\n"+
                        "Please try again!\n"
                , MainMenuOutput.toString());

        // 测试非数字类不能通过验证
        MainMenuOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(MainMenuOutput));
        System.setIn(new ByteArrayInputStream("list of book".getBytes()));
        mainMenu.UserSelectOptions();
        assertEquals(InvalidOption + "\n"+
                        "------------------------------------------------------\n"+
                        "Please try again!\n"
                , MainMenuOutput.toString());
    }

    //*********************************** （1.2）查看书籍清单 *********************************** //
    // 1. 有效选项 => 没有报错
    // 2. 选择1 则出现完整的书籍信息

    @Test // 选择了有效的选项，则没有报错
    public void GetNotifiedWhenChosevalidOption(){
        options = new ArrayList<>(Arrays.asList(option1));
        mainMenu = new MainMenu(options,bookRepository,movieRepository,userRepository);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        mainMenu.UserSelectOptions();
        assertNotEquals(InvalidOption + "\n", MainMenuOutput.toString());
    }










}
