package com.dpf.dp.leet;

/**
 * @author Pikachues
 * Created 2022/1/7
 */
public class Rob2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{200,3,140,20,10}));
    }
  static class Solution {
        public int rob(int[] nums) {
            if(nums==null||nums.length==0){
                return 0;
            }
            int size = nums.length;
            if(size==1){
                return nums[0];
            }else if(size==2){
                return Math.max(nums[0],nums[1]);
            }
            return Math.max(robRand(nums,0,size-2),robRand(nums,1,size-1));
        }

        public int robRand(int[] nums,int start,int end){
            int[] dp = new int[nums.length];
            dp[start] = nums[start];
            dp[start+1] = Math.max(nums[start],nums[start+1]);
            for(int i = start+2;i<=end;i++){
                dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
            }
            return dp[end];
        }
    }
}
