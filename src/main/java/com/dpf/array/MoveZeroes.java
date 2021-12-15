package com.dpf.array;

/**
 * 移动零
 * @Author Pikachues
 * @Date 2021/12/8
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for(int num : nums){
                if(num!=0){
                    nums[index++]=num;
                }
            }
            while(index<nums.length){
                nums[index++]=0;
            }
        }

        public void moveZeroes2(int[] nums) {
            // 不等于0区域
           int mask = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=0){
                    int temp = nums[i];
                    nums[i] = nums[mask];
                    nums[mask++] = temp;
                }
            }
        }
    }
}
