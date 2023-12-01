package com.winston.oiadsl.apttest;

import com.winston.oiadsl.apt.annotation.MyAnnotation;

@MyAnnotation
public class Person {

    private int age;
    private String name;

    public static void main(String[] args) {
        Person person = new Person();
    }

}
