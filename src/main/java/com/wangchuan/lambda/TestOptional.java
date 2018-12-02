package com.wangchuan.lambda;

import java.util.Arrays;
import java.util.Optional;

public class TestOptional {

    public static void test1() {
        String[] s = {"sd", "ae", "er3"};
        Optional<String> max = Arrays.stream(s).max(String::compareToIgnoreCase);
        if (max.isPresent()) {
            System.out.println(max.get());
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
