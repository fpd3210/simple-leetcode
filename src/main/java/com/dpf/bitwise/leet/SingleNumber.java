package com.dpf.bitwise.leet;

/**
 * 只出现一次的位置
 * @author Pikachues
 * Created 2022/1/18
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int i=0;i<nums.length;i++){
                res = res ^ nums[i];
            }
            return res;
        }
    }
}