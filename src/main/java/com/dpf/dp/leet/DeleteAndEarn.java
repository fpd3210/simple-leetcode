package com.dpf.dp.leet;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 删除并获得点数：转化为打家劫舍1
 * @author Pikachues
 * Created 2022/1/8
 */
public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,3,4};

        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn2(nums));


    }
   static class Solution {
        public int deleteAndEarn(int[] nums) {
            if(nums.length==1){
                return nums[0];
            }

            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max,num);
            }
            //max = Arrays.stream(nums).max().getAsInt();

            int[] dp = new int[max+1];
            int[] temp = new int[max+1];
            for (int i = 0; i < nums.length; i++) {
                temp[nums[i]]++;
            }

            dp[1] = temp[1];
            dp[2] = Math.max(dp[1],2*temp[2]);

            for (int i = 3; i <= max; i++) {
                dp[i] = Math.max(dp[i-1],dp[i-2]+temp[i]*i);
            }
            return dp[max];
        }



       public int deleteAndEarn2(int[] nums) {

           if(nums.length==1){
               return nums[0];
           }

           int max = Integer.MIN_VALUE;
           for (int num : nums) {
               max = Math.max(max,num);
           }

           int[] dp = new int[max+1];
           int[] temp = new int[max+1];
           for (int i = 0; i < nums.length; i++) {
               temp[nums[i]]++;
           }

           int first = temp[1];
           int second = Math.max(temp[1],temp[2]*2);

           for (int i = 3; i <= max ; i++) {
               int tem = second;
               second = Math.max(second,temp[i]*i+first);
               first = tem;
           }
           return second;
       }
   }
}

