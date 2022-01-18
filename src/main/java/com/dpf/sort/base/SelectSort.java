package com.dpf.sort.base;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTestUtil.generateRandomArray(maxSize,maxValue);
            int[] arr2 = SortTestUtil.copyArray(arr1);
            selectSort(arr1);
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
     * 思路：每次选取最小的数(记录位置)
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                swap(arr,minIndex,i);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
