package com.dpf.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Pikachues
 * Created 2021/12/22
 */
public class StackTest {

    public static void main(String[] args) {
        testArrayPushPop();
    }

    public static void testLinkedPushPop(){
        Deque<Integer> stack = new LinkedList<>();

        // 头插法
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.poll());
    }

    public static void testArrayPushPop(){
        Deque<Integer> stack = new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.poll());
    }
}
