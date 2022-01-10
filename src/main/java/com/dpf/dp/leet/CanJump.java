package com.dpf.dp.leet;

/**
 * 跳跃游戏
 * @author Pikachues
 * Created 2022/1/9
 */
public class CanJump {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
   static class Solution {
        public boolean canJump(int[] nums) {
            if(nums==null||nums.length==0||nums.length==1){
                return true;
            }
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for(int i=1;i<nums.length;i++){
                dp[i] = isGo(nums,dp,i);
            }
            return dp[nums.length-1];
        }

        public boolean isGo(int[] nums,boolean[] dp,int index){
            for(int i=index-1;i>=0;i--){
                if(dp[i]&&nums[i]>=(index-i)){
                    return true;
                }
            }
            return false;
        }


    }

    class Solution2 {
        public boolean canJump(int[] nums) {
            boolean[] res = new boolean[nums.length];
            res[0] = true;
            for (int i = 0; i < nums.length; i++) {
                if(res[i]){
                    for (int j = 1; j <= nums[i]; j++) {
                        if(i+j>=nums.length-1){
                            return true;
                        }
                        if(i+j<nums.length){
                            res[i+j] = true;
                        }
                    }
                }
            }
            return res[nums.length-1];
        }
    }

    class Solution3 {
        public boolean canJump(int[] nums) {
            int max = nums[0];
            for(int i=1;i<nums.length;i++){
                if(i>max){
                    return false;
                }
                max = Math.max(max,nums[i]+i);
            }
            return true;
        }

    }
}
