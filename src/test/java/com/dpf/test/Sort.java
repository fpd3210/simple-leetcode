package com.dpf.test;

/**
 * @author Pikachues
 * Created 2022/2/14
 */
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = {3,2,1,4,5};
        sort.quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void quickSort(int[] arr){
        if(arr==null||arr.length==1){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex<endIndex){
            int left = startIndex;
            int right = endIndex;
            int pivotValue = arr[startIndex];
            int temp = arr[startIndex];
            while (left<right){
                while (left<right&&arr[right]>pivotValue){
                    right--;
                }
                while (left<right&&arr[left]<=pivotValue){
                    left++;
                }
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            arr[left] = pivotValue;
            arr[startIndex] = temp;
            quickSort(arr, startIndex, left-1);
            quickSort(arr, left+1,endIndex);
        }
    }



}
