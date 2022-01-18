package com.dpf.sort.base;

import java.util.Arrays;

/**
 * 桶排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {32, 67, 45, 73, 22, 11, 89, 100};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxBits(arr));
    }

    public static void radixSort(int[] arr,int begin,int end,int digit){
        final int radix = 10;
        int i=0,j=0;
        // 有多少个数字准备多少个辅助空间
        int[] bucket = new int[end-begin+1];
        for (int d = 1; d <= digit; d++) {
            //  词频划片,count数组含义：各位数上小于等于i的数字有多少个
            int[] count = new int[radix];
            // 词频统计
            for (i = begin;  i<= end ; i++) {
                j = getDigit(arr[i],d);
                count[j]++;
            }
            // 词频分片，各自在自己的片
            for (i = 1; i < radix ; i++) {
                count[i] += count[i-1];
            }
            // 进桶
            for (i = end; i >=begin ; i--) {
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }

            // 出桶
            for (i = begin,j=0; i <= end ; i++,j++) {
                arr[i] = bucket[j];
            }

        }
    }

    /**
     * 获取数字x的倒数第d位数字
     * @param x
     * @param d 1为个位 2为10为
     * @return
     */
    public static int getDigit(int x,int d){
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    /**
     * 获取数组中最大数的有几位
     * @param arr
     * @return
     */
    public static int maxBits(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max!=0){
            res++;
            max/=10;
        }
        return res;
    }
}
