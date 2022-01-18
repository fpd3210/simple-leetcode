package com.dpf.sort.base;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTestUtil.generateRandomArray(maxSize,maxValue);
            int[] arr2 = SortTestUtil.copyArray(arr1);
            insertSort(arr1);
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
     *  0~0 是有序的
     * 0~1希望是有序的
     * 0~2希望是有序的
     * 0~3希望是有序的
     * ....
     * @param arr
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0&&arr[j]>arr[j+1] ; j--) {
                swap(arr, i, j);
            }
            /*for (int j = i-1; j >=0 ; j--) {
                if(arr[j]>arr[j+1]){
                    swap(arr,i,j);
                }
            }*/
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }
}
