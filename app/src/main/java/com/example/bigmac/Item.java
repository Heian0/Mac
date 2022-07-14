package com.example.bigmac;

//Item class representing a real world food entity or meal
public class Item
{
    private String name;
    private int calories;
    private int protein;
    private int fiber;
    private int sodium;
    private int sugar;
    private int carbs;

    /*
    public String toString()
    {
        return "Name: ";
    }
    */

    public String getName() { return name; }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFiber() {
        return fiber;
    }

    public int getSodium() {
        return sodium;
    }

    public int getSugar() {
        return sugar;
    }

    public int getCarbs() { return carbs; }

    Item(String name, int cal, int pro, int fib, int sug, int sod, int carb)
    {
        this.name = name;
        this.calories = cal;
        this.protein = pro;
        this.fiber = fib;
        this.sugar = sug;
        this.sodium = sod;
        this.carbs = carb;
    }

    public void printItem(Item item)
    {
        System.out.println("Name: " + item.name);
        System.out.println("Calories: " + item.calories);
        System.out.println("Protein: " + item.protein);
        System.out.println("Fiber: " + item.fiber);
        System.out.println("Sugar: " + item.sugar);
        System.out.println("Sodium: " + item.sodium);
        System.out.println("Carbs: " + item.carbs);
    }
}
