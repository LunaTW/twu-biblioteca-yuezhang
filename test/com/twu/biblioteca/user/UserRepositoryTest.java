
package com.twu.biblioteca.user;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void UserInformationCanFoundFromAvailableUser(){
        assertEquals(UserRepository.getUser("5102636").getUserName(),"Luna");
    }

    @Test
    public void ID_Pd_areValidCredentials(){}{
        assertTrue(UserRepository.areValidCredentials("5102636","money"));
        assertFalse(UserRepository.areValidCredentials("5102636","Wrong"));
    }

    @Test
    public void Fuction_getUserByUserID(){
        assertEquals(UserRepository.getUserByUserID("5102636").getUserName(),"Luna");
    }
}