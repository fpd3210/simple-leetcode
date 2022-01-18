package com.dpf.queue.base;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Pikachues
 * Created 2021/12/23
 */
public class TestMethod {


    @Test
    public void testSystemArrayCopy(){
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        int[] newArr = new int[15];

        // 将数组arr从0开始的5个元素复制到数组newArr的从0开始的5个位置
        System.arraycopy(arr,0,newArr,0,5);

        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]+" ");
        }


    }

    @Test
    public void testArraysCopy(){
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }

        arr  = Arrays.copyOf(arr, arr.length+arr.length/2);
        System.out.println(arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    @Test
    public void testAddLast(){
        int tail = 0;
        int[] elements = new int[16];

        for (int i = 0; i < elements.length; i++) {
            int temp =(tail + 1) & (elements.length - 1);
            System.out.println(temp);
            tail++;
        }

    }

    @Test
    public void testDoubleCapacity(){
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 17; i++) {
            deque.add(i);
        }
    }

}
