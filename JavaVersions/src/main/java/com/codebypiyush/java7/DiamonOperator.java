package com.codebypiyush.java7;

import java.util.ArrayList;
import java.util.List;

public class DiamonOperator {
    public static void main(String[] args) {

//        on early versions of Java (before 1.5), when generics were not a Java feature,
//        developers have to use raw types declarations and initializations
        List list = new ArrayList();
        list.add(new Object());
        list.add("string");
        list.add(Integer.valueOf(1));

//        String value = list.get(0);   //Runtime Error!
        parameterizedInJava5();
        diamondOperatorJava7();
    }

    static void parameterizedInJava5(){
//        JDK 1.5 brought generics.
//        It enabled compile time safety. It helped in reducing runtime errors by a great number.
        //But specifying String type on right hand side was redundant
        List<String> list = new ArrayList<String>();
        list.add("item 1");
        list.add("item 2");
//        list.add(Integer.valueOf(1)); //Compilation Error
    }

    static void diamondOperatorJava7(){
//        The diamond operator in Java does exactly the same thing. It is also called Elvis operator.
//        Look below at the diamond operator syntax.
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.forEach(System.out::println);
    }
}
