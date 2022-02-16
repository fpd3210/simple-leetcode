package com.dpf.math.leet;

/**
 * 剑指offer44 数字序列中某一位数字
 * @author Pikachues
 * Created 2022/2/10
 */
public class FindNthDigit {

    public static void main(String[] args) {
       String s = "123";

        System.out.println(s.substring(2,3));
    }

    class Solution {
        /**
         * 超时
         * @param n
         * @return
         */
        public int findNthDigit(int n) {
            String s = "";
            for(int i=0;i<n;i++){
                s+=i;
            }
            char[] nums = s.toCharArray();
            System.out.println(n);
            return Integer.valueOf(s.substring(n-1, n));
        }
    }
}
