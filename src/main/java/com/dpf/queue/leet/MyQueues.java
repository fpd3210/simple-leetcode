package com.dpf.queue.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现队列
 * 思路：一个栈用来入栈，另外一个用来出栈，出栈为空时将入栈里的存入出栈
 * @author Pikachues
 * Created 2021/12/22
 */
public class MyQueues {
    class MyQueue {

        Deque<Integer> in;
        Deque<Integer> out;


        public MyQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if(out.isEmpty()){
                inToOut();
            }
            return out.pop();
        }

        public int peek() {
            if(out.isEmpty()){
                inToOut();
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty()&&out.isEmpty();
        }

        public void inToOut(){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }
}
