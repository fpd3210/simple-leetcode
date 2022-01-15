package com.dpf.other;

/**
 * 滑动窗口的最大值
 * @author Pikachues
 * Created 2022/1/15
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(k==0){
            return new int[]{};
        }
        int resLen = nums.length-k+1;
        int[] res = new int[resLen];
        int resIndex = 0;
        for(int i=0;i<len;i++){
            int end = i+k-1;
            if(end<len){
                int max = nums[i];
                for(int j=i+1;j<=end;j++){
                    max = Math.max(max,nums[j]);
                }
                res[resIndex++] = max;
            }
        }
        return res;
    }
}
