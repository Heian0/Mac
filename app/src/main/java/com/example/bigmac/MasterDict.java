package com.example.bigmac;

import java.util.Dictionary;

public class MasterDict
{
    private Dictionary< String, Dictionary<String, Item> > masterDict;

    //for testing, for now Item objects should be put in this dict
    private Dictionary <String, Item> testDict;

    //self explanatory
    public Dictionary< String, Dictionary<String, Item> > getMasterDict()
    {
        return masterDict;
    }

    //self explanatory
    public Dictionary < String, Item > getTestDict()
    {
        return testDict;
    }

    //add dict to masterDict;
    public void addToMasterDict(Dictionary<String, Item> dict)
    {

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

    }
}
