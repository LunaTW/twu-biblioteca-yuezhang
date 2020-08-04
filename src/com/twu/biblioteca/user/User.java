package com.twu.biblioteca.user;

public class User {
    private String UserID;
    private String UserName;
    private String Password;
    private String Email;
    public User(String UserID,String UserName,String Password,String Email){
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = Password;
        this.Email = Email;
    }

    public String getUserID() {
        return UserID;
    }
    public String getUserName() {
        return UserName;
    }
    public String getPassword() {
        return Password;
    }
    public String getEmail(){
        return Email;
    }
    public boolean isValidPassword(String Password) {
        return Password.equals(this.Password);
    }

}
