package com.dpf.stack.base;

import java.util.Arrays;

/**
 * 数组模拟栈
 * @author Pikachues
 * Created 2021/12/21
 */
public class MyArrayStack {

    private final int INIT_SIZE = 100;

    private int[] elements;
    private int size;

    public MyArrayStack() {
       elements = new int[INIT_SIZE];
    }

    /**
     * 入栈
     */
    public void push(int val){
        ensureCapacity();
        elements[++size] = val;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        return elements[--size];
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int peek(){
        return elements[size];
    }

    /**
     * 查询栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 是否需要扩容
     */
    private void ensureCapacity() {
        if(size >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }

    }
}
