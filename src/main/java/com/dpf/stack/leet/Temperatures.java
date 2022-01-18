package com.dpf.stack.leet;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 * @author Pikachues
 * Created 2021/12/23
 */
public class Temperatures {

    class Solution {

        /**
         * 暴力
         * @param temperatures
         * @return
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            for(int i=0;i<temperatures.length;i++){
                for (int j = 0; j < temperatures.length; j++) {
                    if(temperatures[j]>temperatures[i]){
                        res[i] = j-i;
                    }
                }
            }
            return res;
        }


        /**
         * 把小于栈顶元素的下标都入栈，如果当前元素大于栈顶元素，取出栈顶元素，
         *   栈顶元素下标 - 当前元素下标 就是升温间隔天数
         * @param temperatures
         * @return
         */
        public int[] dailyTemperatures2(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Deque<Integer> stack = new ArrayDeque<>();
            for(int i=0;i<temperatures.length;i++){
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    int resIndex = stack.pop();
                    res[resIndex] = i-resIndex;
                }
                stack.push(i);
            }
            return res;
        }
    }
}
