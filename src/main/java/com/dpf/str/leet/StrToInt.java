package com.dpf.str.leet;

/**
 * 把字符串转换成整数
 * @author Pikachues
 * Created 2022/2/14
 */
public class StrToInt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("      -11919730356x"));
    }

    class Solution2 {
        public int strToInt(String str) {
            char[] chars = str.trim().toCharArray();
            if(chars.length==0){
                return 0;
            }
            int res = 0;
            int border=Integer.MAX_VALUE/10;
            int sign = 1;
            int start = 1;
            if(chars[0]=='-'){
                sign = -1;
            }else if(chars[0]!='+'){
                start = 0;
            }

            for (int i = start; i < chars.length; i++) {
                if(chars[i]<'0'||chars[i]>'9'){
                    break;
                }
                if(res>border|| res==border&&chars[i]>'7'){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                res = res * 10+ (chars[i]-'0');
            }

            return res*sign;
        }
    }

    static class Solution {
        public int strToInt(String str) {
            if (str == null || str.trim().length() == 0) {
                return 0;
            }
            str = str.trim();
            char ch = str.charAt(0);
            // 一个字符
            if (str.length() == 1 && !(ch >= '0' && ch <= '9')) {
                return 0;
            }
            // 以 +- 开头
            if (str.startsWith("+-") || str.startsWith("-+")) {
                return 0;
            }

            // 不符合要求排除
            if (!(ch == '+' || ch == '-') && !(ch >= '0' && ch <= '9')) {
                return 0;
            }
            String temp = "";
            // 结果
            int res;
            // 是否非0开头
            boolean isZero = false;
            // =- 数字开头
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                // 中间遇到非数字
                if (i != 0 && !(ch >= '0' && ch <= '9')) {
                    break;
                }
                if (!isZero && ch == '0'&&(ch!='+'||ch!='-')) {
                    continue;
                }
                if(ch!=0&&!(i==0&&(ch=='+'||ch=='-'))){
                    isZero = true;
                }
                temp += String.valueOf(ch);
                if (temp.length() > 11) {
                    break;
                }
            }
            if(temp.length()==0||(temp.length()==1&&(temp.equals("+")||temp.equals("-")))){
                return 0;
            }
            long math = Long.valueOf(temp);

            if (math >= Integer.MIN_VALUE && math <= Integer.MAX_VALUE) {
                res = new Long(math).intValue();
            } else if (math <= Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
            } else {
                res = Integer.MAX_VALUE;
            }

            return res;
        }
    }
}
