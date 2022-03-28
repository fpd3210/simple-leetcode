package com.dpf.math.leet;

/**
 * @author Pikachues
 * Created 2022/3/2
 */
public class LearestPalindromic {
    public static void main(String[] args) {
        System.out.println(1 + 1 >> 1);
        //"807,045,053,224,792,883"
        Solution solution = new Solution();
        System.out.println(solution.nearestPalindromic("12345"));
    }

    static class Solution {
        public String nearestPalindromic(String n) {
            int len = n.length();
            //处理特殊数字 1位数
            if (len == 1) {
                return String.valueOf(Integer.valueOf(n) - 1);
            }
            // 当前值
            long cur = Long.parseLong(n);
            // 当前数位数的最小值  比如19->10
            long curMin = (long) Math.pow(10, len - 1);
            if (cur == curMin || cur == curMin + 1) { // n是10,100,1000....11,101,1001
                return String.valueOf(curMin - 1);
            }
            // 可能的最大值
            long curMax = curMin * 10 - 1;
            if (cur == curMax) { // n是9,99,999....
                return String.valueOf(cur + 2);
            }
            // 非特殊值处理
            int leftMid = Integer.valueOf(n.substring(0, (len + 1) / 2)); // 左半段值
            long ans = Long.MAX_VALUE,abs = Long.MAX_VALUE;
            for(int num:new int[]{1,0,-1}){
                String left = String.valueOf(leftMid+num);

                String full = "";
                if(len%2==0){
                    full = left;
                }else{
                    full = left.substring(0,left.length()-1);
                }
                full = new StringBuilder(full).reverse().insert(0,left).toString();
                if(full.equals(n)){
                    continue;
                }
                long _full = Long.parseLong(full);
                if(Math.abs(_full-cur)<=abs){
                    abs = Math.abs(_full-cur);
                    ans = Math.min(ans,_full);
                }

            }

            return String.valueOf(ans);
        }

    }
}
