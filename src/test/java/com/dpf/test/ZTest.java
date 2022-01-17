package com.dpf.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pikachues
 * Created 2022/1/2
 */
public class ZTest {
    private Integer num1;
    private Integer num2;

    public ZTest(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public ZTest(Integer num1) {
        this(num1,null);
    }

    public static void main(String[] args) {
        int[] temp = new int[]{123};
        List<Integer> collect = Arrays.stream(temp).boxed().collect(Collectors.toList());
    }
}
