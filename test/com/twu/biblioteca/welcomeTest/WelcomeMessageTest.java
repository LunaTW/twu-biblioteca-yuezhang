package com.twu.biblioteca.welcomeTest;


import com.twu.biblioteca.welcome.WelcomeMessage;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

//（1.1）用户能否看到欢迎界面
public class WelcomeMessageTest {
    private String WelcomeMessagecheck = "--------------------------------------------------------------------------------------\n" +
                                         "|                                                                                    |\n" +
                                         "|    Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!   |\n" +
                                         "|                                                                                    |\n" +
                                         "--------------------------------------------------------------------------------------\n";
    @Test
    public void ShouldHaveAWelcomeMessage(){
        ByteArrayOutputStream OutputInformation= new ByteArrayOutputStream();
        System.setOut(new PrintStream(OutputInformation));
        WelcomeMessage.WelcomeMessageInScreen();
        assertEquals(WelcomeMessagecheck , OutputInformation.toString());
    }







}
