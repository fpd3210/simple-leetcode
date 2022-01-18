package com.dpf.queue.base;

import java.util.Arrays;

/**
 * 数组实现队列
 * @author Pikachues
 * Created 2021/12/23
 */
public class MyArrayQueue {
    private int[] elements;
    private int head;
    private int tail;
    private static final int INIT_CAPACITY = 8;

    public MyArrayQueue() {
        elements = new int[INIT_CAPACITY];
        head = 0;
        tail = 0;
    }

    private void add(int val){
      addLast(val);
    }

    public void addLast(int val){
        elements[tail++] = val;
        // 如果超过容量扩容
        if(tail+1== elements.length){
            doubleCapacity();
        }
    }

    public int peek(){
        return elements[head];
    }

    public int poll(){
        return pollFirst();
    }

    public int pollFirst(){
        return elements[head++];
    }


    public void doubleCapacity(){
       elements = Arrays.copyOf(elements,elements.length<<1);
    }

    public int size(){
        return tail-head;
    }

    public static void main(String[] args) {
        MyArrayQueue myArrayQueue = new MyArrayQueue();
        for (int i = 0; i < 16; i++) {
            myArrayQueue.add(i);
        }
        for (int i = 0; i < 16; i++) {
            System.out.println(myArrayQueue.poll()+"-"+ myArrayQueue.size());
        }
    }
}
