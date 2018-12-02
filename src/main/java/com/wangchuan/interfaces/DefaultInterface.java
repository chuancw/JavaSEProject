package com.wangchuan.interfaces;

public interface DefaultInterface
{
    default void print1(){
        System.out.println(1);
    }

    default void print2(){
        System.out.println(2);
    }
}
