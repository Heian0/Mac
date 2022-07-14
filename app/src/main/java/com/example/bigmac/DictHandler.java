package com.example.bigmac;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.databinding.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class DictHandler
{
    private Hashtable< String, Hashtable<String, Item> > masterDict = new Hashtable<>();

    //for testing, for now Item objects should be put in this dict
    public static Hashtable <String, Item> testDict = new Hashtable<>();

    public Hashtable< String, Hashtable<String, Item> > getMasterDict() {return masterDict;}
    public Hashtable< String, Item > getTestDict() {return testDict;}




    //add dict to masterDict;
    public void addToMasterDict(String dictName, Hashtable <String, Item> dict)
    {
        masterDict.put(dictName, dict);
    }

    //adds Item to dict
    public void addItemToDict( Hashtable <String, Item> dict, Item item)
    {
        dict.put(item.getName(), item);
        item.printItem(item);
    }


}
