package com.dpf.stack.leet;

import java.util.*;

/**
 * 字符串解码
 * @author Pikachues
 * Created 2021/12/21
 */
public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[b]]"));
    }
   static class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            Deque<Integer> stackNum = new LinkedList<>();
            Deque<String> stackStr = new LinkedList<>();
            int num = 0;
            for(Character c:s.toCharArray()){
                if(c=='['){
                    stackNum.push(num);
                    stackStr.push(res.toString());
                    num = 0;
                    res = new StringBuilder();
                }else if(c==']'){
                    StringBuilder temp = new StringBuilder();
                    Integer curNum = stackNum.pop();
                    for (int i = 0; i < curNum; i++) {
                        temp.append(res);
                    }
                    res = new StringBuilder(stackStr.pop()+temp);
                }else if(c>='0'&&c<='9'){
                    num = num*10+Integer.parseInt(String.valueOf(c));
                }else {
                    res.append(c);
                }
            }
            return res.toString();
        }
    }
}
