package com.dpf.sort.base;

/**
 * 堆排序
 * 1， 先让整个数组都变成大根堆结构，建立堆的过程:
 *      1)从上到下的方法heapInsert，时间复杂度为O(N*logN)
 *      2)从下到上的方法heapify，时间复杂度为O(N)
 * 2， 把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，一直周而复始，时间复杂度为O(N*logN)
 * 3， 堆的大小减小成0之后，排序完成
 *
 *
 * Java中的优先队列PriorityQueue
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        // 构建大根堆
        for (int i = 0; i < arr.length - 1; i++) {
            heapInsert(arr,i);
        }

        int size = arr.length;
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }

    }

    /**
     * 堆化（调整顺序）
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while (left<size){

            int largestIndex = left+1<size && arr[left+1]>arr[left]?left+1:left;
            largestIndex = arr[index]>arr[largestIndex]?index:largestIndex;
            if(largestIndex==index){
                break;
            }
            swap(arr,index,largestIndex);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }


    /**
     * 构建大顶堆/大根堆
     * 父节点值始终大于两个子节点值
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }



    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
