package com.wangchuan.lambda;

public class Test {

    public static void main(String[] args) {
        InterfaceEx interfaceEx = count -> System.out.println(count);
        interfaceEx.getRun(2);

    }
}
