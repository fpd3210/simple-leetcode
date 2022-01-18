package com.dpf.sort.base;

public class Review {

   static class quickSort{

       public void quickSort(int[] arr){
           if(arr==null||arr.length<2){
               return;
           }
           quickSort(arr,0,arr.length-1);
       }

       public void quickSort(int[] arr,int left,int right){
           if(left<right){
               int mid = partition(arr,0,arr.length-1);
               quickSort(arr,0,mid-1);
               quickSort(arr,mid+1,arr.length-1);
           }
       }

       public int partition(int[] arr,int left,int right){

           int more = right ;
           int less = left-1;

           while (left<more){
               if(arr[left]<arr[right]){
                   swap(arr,++less,left++);
               }else if(arr[more]>arr[right]){
                   swap(arr,left,--more);
               }else{
                   left++;
               }
           }

           swap(arr,more,right);


           return left;
       }

       public void swap(int[] arr,int left,int right){
           int temp = arr[left];
           arr[left] = arr[right];
           arr[right] = temp;
       }
   }

   static class quickSort2{
       public void quickSort(int[] arr){
           if(arr==null||arr.length<2){
               return;
           }

       }
       public void quickSort(int[] arr,int left,int right){
           if(left<right){
               int mid = partition(arr,left,right);
               quickSort(arr,left,mid-1);
               quickSort(arr,left,mid+1);
           }
       }

       private int partition(int[] arr, int left, int right) {
           int pivot = left;
           int pivotValue = arr[pivot];
           for (int i = left+1; i < right; i++) {
               if(arr[i]<pivotValue){
                   swap(arr,++pivot,i);
               }
           }
/*           arr[left] = arr[pivot];
           arr[pivot] = pivotValue;*/
           swap(arr,left,pivot);


           return left;
       }

       private void swap(int[] arr,int left,int right){
           int temp = arr[left];
           arr[left] = arr[right];
           arr[right] = temp;
       }
   }

   static class mergeSort{
       public void mergeSort(int[] arr){
           if(arr==null||arr.length<2){
               return;
           }
           mergeSort(arr,0,arr.length-1);
       }
       public void mergeSort(int[] arr,int left,int right){
           int mid = (left+right)>>2;

           mergeSort(arr,left,mid);
           mergeSort(arr,mid+1,right);
           merge(arr,left,mid,right);
       }

       public void merge(int[] arr,int left,int mid,int right){
           int[] help = new int[right-left+1];
           int helpIndex = left;
           int p1 = left;
           int p2 = mid+1;

           while (p1<=mid&&p2<=right){
               help[helpIndex++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
           }
           while (p1<=mid){
               help[helpIndex++] = arr[p1++];
           }
           while (p2<=right){
               help[helpIndex++] = arr[p2++];
           }

           for (int i = 0; i < help.length; i++) {
               arr[left+i] = help[i];
           }

       }


   }
}
