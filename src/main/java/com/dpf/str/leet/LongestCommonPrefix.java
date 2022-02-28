package com.dpf.str.leet;

/**
 * 最长公共前缀
 * @author Pikachues
 * Created 2022/2/28
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"a","ab"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    /**
     * 横向比较
     */
    static class Solution{
        public String longestCommonPrefix(String[] strs) {
            if(strs==null||strs.length==0){
                return "";
            }
            String pre = strs[0];
            for(int i=1;i<strs.length;i++){
                pre = longestCommonPrefix(pre,strs[i]);
            }

            return pre;
        }
        public String longestCommonPrefix(String s1,String s2){
            int minLength = Math.min(s1.length(),s2.length());
            int len = 0;
            while (len<minLength){
                if(s1.charAt(len)!=s2.charAt(len)){
                    break;
                }
                len++;
            }
            return s1.substring(0,len);
        }
    }


    /**
     * 纵向比较
     */
    static class Solution2{
        public String longestCommonPrefix(String[] strs) {
            if(strs==null||strs.length==0){
                return "";
            }
            for (int i = 0; i < strs[0].length(); i++) {
                char ch = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if(i==strs[j].length()||strs[j].charAt(i)!=ch){
                        return strs[0].substring(0,i);
                    }
                }
            }
            return strs[0];
        }

    }
}
