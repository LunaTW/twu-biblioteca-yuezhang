package com.twu.biblioteca.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    public static List<User> availableUserInformations = new ArrayList<>(Arrays.asList(
            new User("123456","example","123","123456@gmail.com"),
            new User("5102636","Luna","money","unswluna@gmail.com"),
            new User("5123456","ZHANGYUE","ILOVEMONEY","money@gmail.com")
));

    public UserRepository(List<User> availableUserInformations) {
        this.availableUserInformations = availableUserInformations;
    }

    public static User getUser(String UserID) {
        return availableUserInformations.stream().filter(user -> user.getUserID().equals(UserID)).findFirst().orElse(null);
    }
    public static boolean areValidCredentials(String UserID, String Password) {
        User userAccount = getUserByUserID(UserID);
        return userAccount.isValidPassword(Password);
    }

    public static User getUserByUserID(String UserID){
        return availableUserInformations.stream().filter(availableUserInformation->availableUserInformation.getUserID().equals(UserID)).findFirst().get();
    }

    public static void ViewMyInformation(String userID) {
        System.out.printf("%-13s%-2s%-15s%-2s%-19s%-2s%-16s%n","** UserID **","|","** UserName **","|", "** PassWord **","|", "** Email **");
        User USER = UserRepository.getUser(userID);
        System.out.printf("%-13s%-2s%-15s%-2s%-19s%-2s%-16s%n", USER.getUserID(),"|",USER.getUserName(), "|",
                USER.getPassword(), "|", USER.getEmail());
    }
}
