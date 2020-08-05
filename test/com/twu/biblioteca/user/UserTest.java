package com.twu.biblioteca.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User user = new User("5102636","Luna","moneymoneymoney","unswluna@gmail.com");

    @Test
    public void User_CheckFunctionCanBeUsed_ID_UN_PD_EM(){
        assertEquals(user.getUserID(),"5102636");
        assertEquals(user.getUserName(),"Luna");
        assertEquals(user.getPassword(),"moneymoneymoney");
        assertEquals(user.getEmail(),"unswluna@gmail.com");
        assertTrue(user.isValidPassword("moneymoneymoney"));
    }

}