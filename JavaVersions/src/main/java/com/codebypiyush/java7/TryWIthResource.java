package com.codebypiyush.java7;

import java.io.BufferedReader;
import java.util.Scanner;

public class TryWIthResource {

    public static void main(String[] args) {
        try{
            method1();
            System.out.println("After Try block");
        }catch(Exception e){
            System.out.println("Exception handled here");
            e.printStackTrace();
        }
        System.out.println("After Exception handling code");
    }

    private static void method1() {
        int arr[] = new int[5];
        System.out.println("Enter values");
        try(Scanner sc = new Scanner(System.in)){
            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }
            arr[2] = 2;
        }catch(NullPointerException|ArrayIndexOutOfBoundsException ne){
            ne.setStackTrace(new StackTraceElement[3]);
            ne.printStackTrace();
        }catch(Exception ex){}finally{
            //Finally block is used to close all IO objects
            System.out.println("Its in finally block");
//			sc.close(); // It wont work since using try with resources
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        System.out.println("Code is running");
    }

    private static void method2() {
        int arr[] = new int[5];
        arr = null;
        System.out.println("Enter values");
        try(Scanner sc = new Scanner(System.in)){
            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }
            arr[2] = 2;
        }catch(Exception ne){
            ne.setStackTrace(new StackTraceElement[3]);
            ne.printStackTrace();
        }finally{
            //Finally block is used to close all IO objects
            System.out.println("Its in finally block");
//			sc.close(); // It wont work since using try with resources
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        System.out.println("Code is running");
    }
}
