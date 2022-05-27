package com.example.bigmac;

public class User
{
    private String username;
    private int gender;
    private int activity;

    public String getUsername() {
        return username;
    }

    public int getGender() {
        return gender;
    }

    public int getActivity() {
        return activity;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }
}