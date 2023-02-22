package com.ikon.websocketservice;

public class Factorial {


    public static void main(String[] args)
    {
        int target = 5;
        System.out.println("Factorial of "+ target + " is " + factorial(5));
    }


    static int factorial(int n)
    {
        int result = 1, i;
        for (i=2; i<=n; i++)
            result *= i;
        return result;
    }

}

