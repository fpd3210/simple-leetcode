package com.dpf.queue.base;

import java.util.Random;

/**
 * 大顶堆
 * @author Pikachues
 * Created 2022/1/26
 */
public class MaxHeap {

    private int[] data;

    /**
     * 当前堆红存储的数量
     */
    private int size;



    /**
     * 堆中能存储的元素的最大数量
     */
    private int capacity;

    /**
     * 初始化最大堆
     *
     * @param capacity
     */
    public MaxHeap(int capacity) {
        data = new int[capacity+1];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 获取堆中的元素个数
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 向堆中添加元素
     * @param val
     */
    public void add(int val) {
        if(size+1<=capacity){
            data[size+1] = val;
            size++;
            siftUp(size);
        }
    }

    /**
     * 自底向上调整堆结构，用于插入时
     * @param k
     */
    public void siftUp(int k){
        while (k>1&&data[k/2]<data[k]){
            swap(k,k/2);
            k = k/2;
        }
    }

    public void swap(int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 取出最大堆中的跟节点
     * @return
     */
    public int extractMax(){
        if(size>0){
            int res = data[1];
            data[1] = data[size];
            size--;
            siftDown(1);
            return res;
        }
        return -1;
    }

    /**
     * 自顶向下调整堆结构
     * @param k
     */
    private void siftDown(int k) {
        while (2*k<=size){
            int j = 2*k;
            if(j+1<=size&&data[j+1]>data[j]){
                j++;
            }
            if(data[k]>data[j]){
                break;
            }

            swap(j,k);
            k = j;
        }
    }

    public static void main(String[] args) {
        int size = 1000000;
        MaxHeap maxHeap = new MaxHeap(size);

        Random random = new Random();

        int[] arr = {91,43,19,37,9,17};

        for (int i = 0; i < size; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < res.length; i++) {
            if(res[i]>res[i-1]){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");
    }

}
