package com.dpf.test;

import com.dpf.sort.base.SortTestUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Pikachues
 * Created 2022/2/14
 */
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int testCount = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr1 = SortTestUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortTestUtil.copyArray(arr1);
            sort.mergeSort(arr1);
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

    public void mergeSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public void mergeSort(int[] arr,int startIndex,int endIndex){
       if(startIndex==endIndex){
           return;
       }
        int mid = (startIndex+endIndex)/2;
        mergeSort(arr,startIndex,mid);
        mergeSort(arr,mid+1,endIndex);
        merge(arr,startIndex,mid,endIndex);
    }

    public void merge(int[] arr,int startIndex,int mid,int endIndex){
        int index = 0;
        int[] help = new int[endIndex-startIndex+1];
        int p1 = startIndex,p2=mid+1;
        while (p1<=mid&&p2<=endIndex){
            help[index++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[index++]=arr[p1++];
        }
        while (p2<=endIndex){
            help[index++]=arr[p2++];
        }
        for (int i = 0; i < index; i++) {
            arr[startIndex+i] = help[i];
        }
    }



}
