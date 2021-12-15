package com.dpf.sort.base;

import java.util.Arrays;

/**
 * 归并排序
 * 思想：找中间位置，左边排好序，右边排好序，让整体有序
 *
 * O(n^2)缺点
 * 大量浪费比较行为才定出一个数
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,2,6,4,3,0};
        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        // 中间位置左边有序
        mergeSort(arr, l, mid);
        // 中间位置右边有序
        mergeSort(arr, mid + 1, r);
        // 合并左右两个有序段
        merge(arr, l, mid, r);
    }

    /**
     * 双指针合并，小的先放辅助空间，最后将辅助空间排好序放到原数组
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    public static void merge(int[] arr,int l,int m,int r){

        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }
}
