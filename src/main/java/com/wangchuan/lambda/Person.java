package com.wangchuan.lambda;

public class Person implements Comparable {

    private int age;


    /**
     * -1  小到大
     * 1   大到小
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        Person person = (Person)o;
        return -Double.compare(this.age,person.age);
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Person() {
    }

}
