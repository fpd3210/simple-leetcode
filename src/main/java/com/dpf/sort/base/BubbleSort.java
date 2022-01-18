package com.dpf.sort.base;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTestUtil.generateRandomArray(maxSize,maxValue);
            int[] arr2 = SortTestUtil.copyArray(arr1);
            bubbleSort(arr1);
            SortTestUtil.comparator(arr2);
            if (!SortTestUtil.isEqual(arr1,arr2)){
                succeed = false;
                SortTestUtil.printArray(arr1);
                SortTestUtil.printArray(arr2);
                break;
            }
        }

        System.out.println(succeed?"Nice!":"Failed");
    }

    /**
     * 每次选取最小的数，交换位置
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }

}
