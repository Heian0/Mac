package com.example.bigmac;

import java.util.Hashtable;

//a user representing a real world user
public class User
{
    private String username;
    private int gender;
    private int activity;

    public Hashtable<String, Integer> userDailyMacrosDict = new Hashtable<>();

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

    //sets all macro counts to be zero
    public void setDailyMacros()
    {
        userDailyMacrosDict.clear();
        userDailyMacrosDict.put("cal", 0);
        userDailyMacrosDict.put("pro", 0);
        userDailyMacrosDict.put("fib", 0);
        userDailyMacrosDict.put("sod", 0);
        userDailyMacrosDict.put("sug", 0);
        userDailyMacrosDict.put("carb", 0);
    }
}