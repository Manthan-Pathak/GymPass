package com.example.activity_signup;

public class User {

    private String Phone;
    private String Pass;
    private String Email;
    private String Name;

    public User() {
    }

    public User(String phone, String pass, String email, String name) {
        Phone = phone;
        Pass = pass;
        Email = email;
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
