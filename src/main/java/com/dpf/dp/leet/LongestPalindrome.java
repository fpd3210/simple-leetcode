package com.dpf.dp.leet;

/**
 * 最长回文子串
 * @author Pikachues
 * Created 2022/1/14
 */
public class LongestPalindrome {
    /**
     * dp
     */
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if(len<2){
                return s;
            }

            boolean[][] dp = new boolean[len][len];
            // 单个字符都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            int maxLength = 1;
            int begin = 0;

            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    // 如果首字符不等于尾字符，那么不是回文串
                    if(s.charAt(i)!=s.charAt(j)){
                        dp[i][j] = false;
                    }else if(j-i<3){
                        // 长度小于4，且首字符等于尾字符，那么说明是回文串
                        dp[i][j] = true;
                    }else{
                        // 长度大于等于4，缩短看中间是否为回文串
                        dp[i][j] = dp[i+1][j-1];
                    }

                    // 如果当前是回文串，更新最大回文串的起始点，跟长度
                    if(dp[i][j]&&(j-i+1)>maxLength){
                        maxLength = j-i+1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin,begin+maxLength);
        }
    }

    /**
     * 中心扩散解法
     */
    class Solution2 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if(len<2){
                return s;
            }
            // 第一位记录起始位置， 第二问记录长度
            int[] res = new int[2];

            for (int i = 0; i < len - 1; i++) {
                int[] odd = midExpand(s,i,i);
                int[] even = midExpand(s,i,i+1);
                int[] max = odd[1]>even[1]?odd:even;
                if(max[1]>res[1]){
                    res[1] = max[1];
                    res[0] = max[0];
                }
            }
            return s.substring(res[0],res[0]+res[1]);
        }

        public int[] midExpand(String s,int left,int right){
            int len = s.length();
            while (right<len&&left>=0){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }else {
                    break;
                }
            }
            return new int[]{left+1,right-left-1};
        }
    }
}
