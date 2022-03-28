package com.dpf.sort.base;

import java.util.*;

/**
 * @author Pikachues
 * Created 2022/2/15
 */
public class QuickSorts {

    public static void main(String[] args) {
        QuickSort2 quickSort1 = new QuickSort2();
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTestUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortTestUtil.copyArray(arr1);
            quickSort1.quickSort(arr1,0, arr1.length-1);
            Arrays.sort(arr2);
            if (!SortTestUtil.isEqual(arr1, arr2)) {
                succeed = false;
                SortTestUtil.printArray(arr1);
                SortTestUtil.printArray(arr2);
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Failed");
    }

    /**
     * 单边循环
     */
    static class QuickSort1 {
        public void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            quickSort(arr, 0, arr.length - 1);
        }

        public void quickSort(int[] arr, int startIndex, int endIndex) {
            if (startIndex < endIndex) {
                // 基准值
                int pivotValue = arr[startIndex];
                // 基准值下标
                int mask = startIndex;
                for (int i = startIndex + 1; i <= endIndex; i++) {
                    // 比基准值小的放到基准值左边
                    if (arr[i] < pivotValue) {
                        // 小于基准值的区域+1
                        mask++;
                        int temp = arr[mask];
                        arr[mask] = arr[i];
                        arr[i] = temp;
                    }
                }
                // 将基准值放到对应位置
                arr[startIndex] = arr[mask];
                arr[mask] = pivotValue;

                quickSort(arr, startIndex, mask - 1);
                quickSort(arr, mask + 1, endIndex);
            }
        }
    }

    /**
     * 单边循环  非递归
     */
    static class QuickSort1_1 {
        public void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            Deque<Map<String, Integer>> stack = new ArrayDeque<>();
            Map<String, Integer> rooParam = new HashMap<>();
            rooParam.put("startIndex", 0);
            rooParam.put("endIndex", arr.length - 1);
            stack.push(rooParam);
            while (!stack.isEmpty()) {
                Map<String, Integer> param = stack.pop();
                int startIndex = param.get("startIndex");
                int endIndex = param.get("endIndex");

                int pivotValue = arr[startIndex];
                int mask = startIndex;
                for (int i = startIndex + 1; i <= endIndex; i++) {
                    if(arr[i]<pivotValue){
                        mask++;
                        int temp = arr[mask];
                        arr[mask] = arr[i];
                        arr[i] = temp;
                    }
                }
                arr[startIndex] = arr[mask];
                arr[mask] = pivotValue;

                if(mask-1>startIndex){
                    HashMap<String , Integer> leftParam = new HashMap<>();
                    leftParam.put("startIndex",startIndex);
                    leftParam.put("endIndex",mask-1);
                    stack.push(leftParam);
                }

                if(mask+1<endIndex){
                    HashMap<String , Integer> rightParam = new HashMap<>();
                    rightParam.put("startIndex",mask+1);
                    rightParam.put("endIndex",endIndex);
                    stack.push(rightParam);
                }
            }
        }

    }

    /**
     * 双边循环
     */
    static class QuickSort2 {
        public void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            quickSort(arr, 0, arr.length - 1);
        }

        public void quickSort(int[] arr, int startIndex, int endIndex) {
            if (startIndex < endIndex) {
                // 基准值
                int pivot = arr[startIndex];
                int left = startIndex;
                int right = endIndex;
                while (left < right) {
                    while (left < right && arr[right] > pivot) {
                        right--;
                    }
                    while (left < right && arr[left] <= pivot) {
                        left++;
                    }
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                arr[startIndex] = arr[left];
                arr[left] = pivot;

                quickSort(arr, startIndex, left - 1);
                quickSort(arr, left + 1, endIndex);
            }

        }
    }

    /**
     * 优化版本
     */
    static class QuickSort3 {
        public void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            quickSort(arr, 0, arr.length - 1);
        }

        public void quickSort(int[] arr, int startIndex, int endIndex) {
            if (startIndex < endIndex) {
                int start = startIndex;
                int less = startIndex-1;
                int more = endIndex;
                // endIndex为基准下标
                while (startIndex<more){
                    if(arr[startIndex]<arr[endIndex]){
                        // 记录小于基准值区间
                        swap(arr,++less,startIndex++);
                    }else if(arr[startIndex]>arr[endIndex]){
                        swap(arr,--more,startIndex);
                    }else {
                        startIndex++;
                    }
                }
                swap(arr,more,endIndex);
                quickSort(arr,start,less);
                quickSort(arr,more+1,endIndex);
            }
        }

        public void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
