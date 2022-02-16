package com.dpf.str.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * @author Pikachues
 * Created 2022/2/13
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aaa"));
    }

    static class Solution {
        /**
         * 滑动窗口
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int start = -1;
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                // 遇到重复字符更新起始下标
                if (map.containsKey(ch)) {
                    start = Math.max(start, map.get(ch));
                }
                // 有重复更新字符下标
                map.put(ch, i);
                // 每次取字串最大值
                max = Math.max(max, i - start);
                String temp="";
                if(start==-1){
                    temp = s.substring(0,i);
                }else {
                    temp = s.substring(start,i);
                }
                res = res.length()<temp.length()?temp:res;
            }

            return max;
        }


    }
}
