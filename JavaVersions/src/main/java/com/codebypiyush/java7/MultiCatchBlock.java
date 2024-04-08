package com.codebypiyush.java7;

import java.io.*;

public class MultiCatchBlock {
    //Java 7 introduced multi-catch blocks, allowing a single catch block to handle multiple types of exceptions.
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException | NumberFormatException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
}
