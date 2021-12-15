package com.dpf.search.leet;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @Author Pikachues
 * @Date 2021/12/7
 */
public class SearchRange {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{2};
        for (int i : solution.searchRange(ints, 3)) {
            System.out.println(i);
        }
    }

     static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            boolean flag = false;

            while(left<=right){
                int mid = (left+right)>>1;
                if(nums[mid]==target){
                    left = mid;
                    flag = true;
                    break;
                }else if(nums[mid]>target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            if(flag){
                right = left;
                while(left>=0&&nums[left]==target){
                    left--;
                }
                while(right<nums.length&&nums[right]==target){
                    right++;
                }
            }

            return flag?new int[]{++left,--right}:new int[]{-1,-1};
        }
    }
}
