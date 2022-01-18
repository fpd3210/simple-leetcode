package com.dpf.search.base;

/**
 *
 * @Author Pikachues
 * @Date 2021/12/7
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3};
        System.out.println(binarySearch2(arr,1));
    }

    /**
     * 递归实现
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr,int target){
        return binarySearch(arr,target,0,arr.length-1);
    }

    public static int binarySearch(int[] arr,int target,int left,int right){

        if(left<=right){
            int mid = (left+right)>>1;
            if(arr[mid]==target){
                return mid;
            } else if(arr[mid]>target){
                return binarySearch(arr, target, left, mid-1);
            }if(arr[mid]<target){
                return binarySearch(arr, target, mid+1, right);
            }
        }
        return -1;
    }

    /**
     * 非递归实现
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch2(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        boolean flag = false;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if(arr[mid]==target){
                left = mid;
                flag = true;
                break;
            }else if(arr[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return flag?left:-1;
    }
}
