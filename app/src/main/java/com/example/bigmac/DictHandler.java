package com.example.bigmac;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class DictHandler
{
    private Dictionary< String, Dictionary<String, Item> > masterDict = new Hashtable<>();

    //for testing, for now Item objects should be put in this dict
    public Dictionary <String, Item> testDict = new Hashtable<>();

    public Dictionary< String, Dictionary<String, Item> > getMasterDict() {return masterDict;}
    public Dictionary< String, Item > getTestDict() {return testDict;}

    //add dict to masterDict;
    public void addToMasterDict(String dictName, Dictionary <String, Item> dict)
    {
        masterDict.put(dictName, dict);
    }

    //input from file (data storage) should be written to dict
    public void writeToDict(Dictionary<String, Item> dict, String file)
    {

    }

    //data in dict should be outputted to file to update data after user adds a new Item
    public void writeToFile(Dictionary<String, Item> dict, String file)
    {

    }

    //self explanatory
    public void addItemToDict( Dictionary <String, Item> dict, Item item)
    {
        dict.put(item.getName(), item);
        item.printItem(item);
    }
}
