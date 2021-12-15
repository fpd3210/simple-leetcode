package com.dpf.sort.base;

/**
 * 小和问题
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(mergeSort(arr));
    }

    public static int mergeSort(int[] arr){
        if(arr==null||arr.length<2){
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }

    public static int mergeSort(int[] arr,int l,int r){
        if(l==r){
            return 0;
        }
        int mid = l + ((r-l)>>1);
        return mergeSort(arr,l,mid)+mergeSort(arr,mid+1,r)+merge(arr,l,mid,r);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        int res = 0;
        while (p1<=m&&p2<=r){
            res += arr[p1] < arr[p2]?(r-p2+1)*arr[p1]:0;
            help[i++] = arr[p1] < arr[p2]?arr[p1++]:arr[p2++];
        }

        while (p1<=m){
            help[i++] = arr[p1++];
        }

        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
        return res;
    }
}
