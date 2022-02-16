package com.dpf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pikachues
 * Created 2022/2/11
 */
public class TestList {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(s.length());
        List<Integer> list = new ArrayList<>();
        System.out.println(list.add(1));
        System.out.println(list.add(2));
        System.out.println(list.add(3));

        Integer[] integers = list.toArray(new Integer[0]);

        Arrays.stream(integers).forEach(System.out::println);

    }
}
