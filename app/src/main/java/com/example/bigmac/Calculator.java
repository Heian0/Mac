package com.example.bigmac;

public class Calculator
{
    //Returns maintenance calories based on given parameters using the Mifflin-St Jeor Equation
    public int CalculateMCal(int age, int height, int weight, int gender, int activity)
    {
        float TDEE = 0f;

        switch (activity)
        {
            case 0: TDEE = 1.2f; break;
            case 1: TDEE = 1.375f; break;
            case 2: TDEE = 1.5f; break;
            case 3: TDEE = 1.725f; break;
            case 4: TDEE = 1.9f; break;
        }

        if (gender == 0) return Math.round(TDEE * (10 * weight + 6.25f * height - 5 * age + 5));
        else return Math.round(TDEE * (10 * weight + 6.25f * height - 5 * age - 161));
    }
}
