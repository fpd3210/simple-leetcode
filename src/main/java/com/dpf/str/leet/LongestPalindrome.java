package com.dpf.str.leet;

/**
 * 最长回文串
 * @author Pikachues
 * Created 2022/7/6
 */
public class LongestPalindrome {


    /**
     * 方法1 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int strLen = s.length();
        // 回文串左下标
        int left = 0;
        // 回文串右下标
        int right = 0;
        // 当前回文串长度
        int curLen = 1;
        // 最大回文串的开始文职
        int maxStart = 0;
        // 最大回文串的长度
        int maxLen = 0;
        for (int i = 0; i < strLen; i++) {
            left = i-1;
            right = i+1;
            while (left>=0&&s.charAt(left)==s.charAt(i)){
                left--;
                curLen++;
            }
            while (right<strLen&&s.charAt(right)==s.charAt(i)){
                right++;
                curLen++;
            }
            while (left>=0&&right<strLen&&s.charAt(left)==s.charAt(right)){
                curLen+=2;
                left--;
                right++;
            }
            if(curLen>maxLen){
                maxLen = curLen;
                maxStart = left-1;
            }
            curLen = 1;

        }
        return s.substring(maxStart,maxStart+maxLen);
    }

    /*=========================================================================*/

    /**
     * 方法2 暴力
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, j + 1);
                if (isHuiwenStr(temp)) {
                    res = res.length() > temp.length() ? res : temp;
                }
            }
        }
        return res;
    }

    /**
     * 双指针判断是否回文串
     * @param s
     * @return
     */
    public boolean isHuiwenStr(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
