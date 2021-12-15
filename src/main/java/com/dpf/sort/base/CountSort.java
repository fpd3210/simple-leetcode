package com.dpf.sort.base;

import java.util.Arrays;

/**
 * 记数排序
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 2, 1, 5, 4, 7, 9, 8};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max= Math.max(max,arr[i]);
        }
        int[] bucket = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]>0){
                arr[index++]=i;
                bucket[i]--;
            }
        }
    }
}
