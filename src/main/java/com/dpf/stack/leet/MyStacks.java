package com.dpf.stack.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个队列模拟栈
 * @author Pikachues
 * Created 2021/12/22
 */
public class MyStacks {
    /**
     * 两个栈，一个辅助栈，一个存储栈
     * 入栈时先将数据存入辅助栈，然后将存储栈里的数据也存入辅助栈，这时候最后入的刚好的栈顶
     * 把辅助栈赋值给存储栈
     */
    class MyStack {
        // 存储
        Deque<Integer> res;
        // 辅助
        Deque<Integer> help;

        public MyStack() {
            res = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int x) {
              help.add(x);
              while (!res.isEmpty()){
                  help.add(res.poll());
              }
              Deque<Integer> temp = res;
              res = help;
              help = temp;
        }

        /**
         *  移除并返回栈顶元素。
         * @return
         */
        public int pop() {
           return res.poll();
        }

        /**
         * 查看栈顶元素
         * @return
         */
        public int top() {
            return res.peek();
        }

        public boolean empty() {
            return res.isEmpty();
        }
    }

}
