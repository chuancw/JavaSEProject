package com.wangchuan.lambda;

import java.util.Arrays;

public class TestLambda {

    public static void printInstanceOf(){

        Person person = new Person();
        System.out.println(person instanceof Comparable);
    }

    public static void main(String[] args) {


        Person person1 = new Person(23);
        Person person2 = new Person(24);

        System.out.println(person1.compareTo(person2));

        Person[] person = {person1, person2};
        Arrays.sort(person);
        for(Person persons:person){
            System.out.println(persons.getAge());
        }

        printInstanceOf();

    }
}
