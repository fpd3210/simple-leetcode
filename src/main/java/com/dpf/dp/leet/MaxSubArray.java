package com.dpf.dp.leet;

import java.util.Arrays;

/**
 * 最大子数组和
 * @author Pikachues
 * Created 2022/1/10
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int size = nums.length;
            int[] dp = new int[size];
            dp[0] = nums[0];
            for(int i=1;i<size;i++){
                if(dp[i-1]>0){
                    dp[i] = dp[i-1]+nums[i];
                }else{
                    dp[i] = nums[i];
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }
}

