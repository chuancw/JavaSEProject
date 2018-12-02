package com.wangchuan.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i<s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }

    public static void testComparator() {
        List<String> strings = Arrays.asList("ae", "w1ea", "sf34w", "2ea");
        //字典顺序
        List<String> collect = strings.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        //长度
        List<String> collect0 = strings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        //默认是字典顺序
        List<String> collect1 = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect0);
        System.out.println(collect1);
    }

    public static void testOptional() {
        List<String> strings = Arrays.asList("x3", "a");
        Optional<String> max = strings.stream().max(String::compareToIgnoreCase);
        Optional<String> max1 = strings.stream().max(Comparator.comparing(String::length));
        Optional<String> any = strings.stream().filter(s -> s.length() > 4).findAny();

        System.out.println(max.get());
        System.out.println(max1.get());
        String s = any.orElse("");
        System.out.println("s="+s);
        any.ifPresent(System.out::println);
        System.out.println(any.isPresent());
    }

    /**
     * 拼接流中的字符串
     */
    public static void testCollector_join() {
        List<String> strings = Arrays.asList("123", "sc", "we");
        String collect = strings.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
    }

    /**
     * toMap
     */
    public static void testCollector_toMap() {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("wangchuan", "22"));
        peopleList.add(new People("lizechuan", "23"));

        Map<String, String> collect = peopleList.stream()
                .collect(Collectors.toMap(People::getName, People::getAge));
        System.out.println(collect);

        //Function.identity()
        Map<String, People> collect1 = peopleList.stream()
                .collect(Collectors.toMap(People::getName, Function.identity()));
        System.out.println(collect1);

        //解决key值重复问题
        peopleList.add(new People("wangchuan", "20"));
        Map<String, String> collect2 = peopleList.stream()
                .collect(Collectors.toMap(People::getName, People::getAge, (exitValue, newValue) -> exitValue));
        System.out.println(collect2);
    }

    /**
     * 分组
     */
    public static void testCollector_groupingBy() {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("1", "aa"));
        peopleList.add(new People("1", "bb"));
        peopleList.add(new People("2", "cc"));

        Map<String, List<People>> collect = peopleList.stream().collect(Collectors.groupingBy(People::getName));
        System.out.println(collect);

        Map<Boolean, List<People>> collect1 = peopleList.stream().collect(Collectors.groupingBy(value -> value.getName().equals("1")));
        System.out.println(collect1);

        Map<Boolean, List<People>> collect2 = peopleList.stream().collect(Collectors.partitioningBy(value -> value.getName().equals("1")));
        System.out.println(collect2);

        List<People> collect3 = peopleList.stream().filter(value -> value.getName().equals("1")).collect(Collectors.toList());
        System.out.println(collect3);

        Map<String, Long> collect4 = peopleList.stream().collect(Collectors.groupingBy(People::getName, Collectors.counting()));
        System.out.println(collect4);

        long count = peopleList.stream().filter(people -> people.getName().equals("1")).count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        testComparator();
        testOptional();
        testCollector_join();
        testCollector_toMap();
        testCollector_groupingBy();
    }

}
