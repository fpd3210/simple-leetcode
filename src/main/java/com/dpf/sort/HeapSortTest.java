package com.dpf.sort;

import java.util.Arrays;

/**
 * @author Pikachues
 * Created 2022/1/28
 */
public class HeapSortTest {

    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            siftDown(arr, i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            siftDown(arr, i);
        }

    }

    /**
     * 自底向上调整堆结构，用于插入时
     *
     * @param k
     */
    public void siftUp(int[] data, int k) {
        while (k > 0 && data[(k - 1) / 2] < data[k]) {
            swap(data, k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    /**
     * 自顶向下调整堆结构
     *
     * @param k
     */
    private void siftDown(int[] data, int k) {
        while (2 * k + 1 < data.length) {
            int j = 2 * k + 1;
            if (j + 1 < data.length && data[j + 1] > data[j]) {
                j++;
            }
            if (data[k] > data[j]) {
                break;
            }
            swap(data,j, k);
            k = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 1, 6, 4, 3};

        HeapSortTest heapSortTest = new HeapSortTest();
        heapSortTest.heapSort(arr);

        for (int n : arr) {
            System.out.println(n);
        }
    }
}
