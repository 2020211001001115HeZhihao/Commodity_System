package com.example.commodity_system.Model;

public class User {
    int  User_id;
    String Username;
    String Password;
    int type;

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + User_id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", type=" + type +
                '}';
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
