package com.wangchuan.template;

public class Test {

    /**
     * 泛型方法
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }



    public static void main(String[] args) {
        String abc = getMiddle("123", "abc");
        System.out.println(abc);
    }
}
