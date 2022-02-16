package com.dpf.stack.leet;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈的压入与弹出序列
 * @author Pikachues
 * Created 2022/2/8
 */
public class ValidateStackSequences {
    class Solution{
        /**
         * 判断按照出栈结果出栈是否所有内容都能出栈
         * @param pushed
         * @param popped
         * @return
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int index = 0;
            for (int num : pushed) {
                stack.push(num);
                while (!stack.isEmpty()&&popped[index]==stack.peek()){
                    stack.pop();
                    index++;
                }
            }

            return stack.isEmpty();
        }
    }
}
