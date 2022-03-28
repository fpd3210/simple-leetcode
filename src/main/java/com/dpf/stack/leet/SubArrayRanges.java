package com.dpf.stack.leet;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Pikachues
 * Created 2022/3/4
 */
public class SubArrayRanges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3};
        System.out.println(solution.subArrayRanges(arr));
    }
    static class Solution{
        int n;
        public long subArrayRanges(int[] nums) {
            n = nums.length;
            return sumMax(nums)-sumMin(nums);
        }

        private long sumMin(int[] nums){
            int[] preSmaller = new int[n];
            int[] nextSmaller = new int[n];

            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty()&&
                        nums[stack.peek()]>=nums[i]){
                    // 栈单调递增
                    stack.pop();
                }
                preSmaller[i] = stack.isEmpty()?-1:stack.peek();
                stack.push(i);

            }
            stack.clear();

            for (int i = n-1; i >=0 ; i--) {
                while (!stack.isEmpty()&&
                        nums[stack.peek()]>nums[i]){
                    stack.pop();
                }
                nextSmaller[i] = stack.isEmpty()?n:stack.peek();
                stack.push(i);

            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
               ans += (long) (i - preSmaller[i]) * (nextSmaller[i] - i);
            }
            return ans;
        }

        private long sumMax(int[] nums){
            int[] preBigger = new int[n];
            int[] nextBigger = new int[n];

            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty()&&
                        nums[stack.peek()]<=nums[i]){

                    stack.pop();
                }
                preBigger[i] = stack.isEmpty()?-1:stack.peek();
                stack.push(i);

            }
            stack.clear();

            for (int i = n-1; i >=0 ; i--) {
                while (!stack.isEmpty()&&
                        nums[stack.peek()]<nums[i]){
                    stack.pop();
                }
                nextBigger[i] = stack.isEmpty()?n:stack.peek();
                stack.push(i);

            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (long) (i - preBigger[i]) * (nextBigger[i] - i);
            }
            return ans;
        }

    }

}
