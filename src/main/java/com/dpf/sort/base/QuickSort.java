package com.dpf.sort.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 * 思想：找一个基准值，每次让基准值左边的值都小于它，右边的值都大于它
 *      再找基准值直到有序
 */
public class QuickSort {

    public static void main(String[] args) {
        int testCount = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTestUtil.generateRandomArray(maxSize,maxValue);
            int[] arr2 = SortTestUtil.copyArray(arr1);
            quickSort(arr1);
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
     * 快排非递归实现，参考漫画算法（绝大多数递归逻辑都可以采用栈来代替）
     * @param arr
     */
    public static void quickSortNoRecursion(int[] arr){

        if(arr==null||arr.length<2){
            return;
        }

        Stack<Map<String,Integer>> quickSortStack = new Stack<>();
        HashMap<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex",0);
        rootParam.put("endIndex",arr.length-1);
        quickSortStack.push(rootParam);
        while (!quickSortStack.isEmpty()){
            Map<String, Integer> param = quickSortStack.pop();
            int pivotIndex = partition(arr,param.get("startIndex"),param.get("endIndex"));

            if(param.get("startIndex")<pivotIndex-1){
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }

            if(pivotIndex+1<param.get("endIndex")){
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }


    }

    public static void quickSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        // 递归结束条件
        if(startIndex>=endIndex){
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partitionDouble(arr,startIndex,endIndex);
        partitionDouble(arr,startIndex,pivotIndex-1);
        partitionDouble(arr,pivotIndex+1,endIndex);
    }

    /**
     * 分治，单指针
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {

        // 基准下标值
        int pivotValue = arr[startIndex];
        // 基准下标
        int mark = startIndex;

        for (int i = startIndex+1; i <= endIndex; i++) {
            // 比基准值小的放到基准值的前面
            if(arr[i]<pivotValue){
                // 小于基准值得区域增加一个
                mark++;
                swap(arr,mark,i);
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivotValue;
        return mark;
    }

    /**
     * 分治，双边循环
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    // TODO: 2021/12/20 存在问题
    private static int partitionDouble(int[] arr,int startIndex,int endIndex){
        int pivotValue = arr[startIndex];
        int left = startIndex+1;
        int right = endIndex;

        while (left<right){
            while (left<right&&arr[right]>pivotValue){
                right--;
            }
            while (left<right&&arr[left]<=pivotValue){
                left++;
            }
            if(left<right){
                swap(arr,left,right);
            }
        }

        arr[startIndex] = arr[left];
        arr[left] = pivotValue;

        return left;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /*++++++++++++++++++++++++++++++++++++优化版本，跳过与基准值相等的数++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public static void newQuicklySort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        newQuicklySort(arr,0,arr.length-1);
    }

    private static void newQuicklySort(int[] arr, int l, int r) {
        if(l<r){
            //swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] pivots = newPartition(arr,l,r);
            newQuicklySort(arr,l,pivots[0]-1);
            newQuicklySort(arr,pivots[1]+1,r);
        }
    }

    private static int[] newPartition(int[] arr, int l, int r) {
        // 小于基准值左区间
        int less = l-1;
        // 大于基准值右区间
        int more = r;
        while (l<more){
            if(arr[l]<arr[r]){
                // 记录左区间位置，自身跟自身交换
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }

        swap(arr,more,r);

        return new int[]{less+1,more};
    }


}
