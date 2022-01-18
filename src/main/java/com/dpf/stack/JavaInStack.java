package com.dpf.stack;

import org.junit.Test;

import java.beans.Transient;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Java中没有对应的栈接口，但是有Stack类，它是基于Vector实现的。Java中使用栈更推荐使用Deque的实现类来完成栈的相关操作，
 * 因为Vector的相关方法都是加锁实现的，效率相对低。
 */
public class JavaInStack {

    public static void main(String[] args) {
        base();
    }

    public static void base(){
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        /*###########################栈转数组#############################*/
        Deque<Integer> stack2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            stack2.push(i);
        }
        Integer[] integers1 = Arrays.stream(stack2.toArray()).toArray(Integer[]::new);
        Integer[] integers2 = stack2.toArray(new Integer[stack2.size()]);
        System.out.println(Arrays.toString(integers1));
        System.out.println(Arrays.toString(integers2));

        int[] ints = Arrays.stream(stack2.toArray()).mapToInt(num -> (Integer) num).toArray();


    }

    /**
     * 栈转数组
     */
    @Test
    public void testStackToArray(){
        Deque<Integer> stack2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            stack2.push(i);
        }
        Integer[] integers2 = stack2.stream().toArray(Integer[]::new);
    }

}
