package com.dpf.sort.base;

public class MaxNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,7,9,8,2,4,11,77,99,1,3,4,5,6,7,8,9,0};
        System.out.println(getMaxNum(arr,0,arr.length-1));
    }

    // 用递归求数组中的最大值
    public static int getMaxNum(int[] arr,int l,int r){
       if(l==r){
           return arr[l];
       }

       // mid = (l+r)/2
       // mid = l + (r-l)/2
       int mid = l + ((r-l) >> 1);

       int leftMax = getMaxNum(arr,l,mid);
       int rightMax = getMaxNum(arr,mid+1,r);
        return Math.max(leftMax,rightMax);
    }
}
