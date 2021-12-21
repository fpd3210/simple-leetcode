package com.dpf.stack.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Pikachues
 * Created 2021/12/21
 */
public class MinStacks {
    static class MinStack {
        Node head;

        public MinStack() {

        }

        public void push(int val) {
            if(head==null){
                head = new Node(val,val);
            }else {
                head =  new Node(val, Math.min(val, head.min),head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
           return head.min;
        }
    }

   static class Node{
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this(val,min,null);
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    /*****************************************************************************************************************/
    static class MinStack2 {

        Deque<Integer> stack;
        Deque<Integer> xStack;

        public MinStack2() {
            stack = new LinkedList<>();
            xStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            if(xStack.isEmpty()||xStack.peek()>=val){
                xStack.push(val);
            }
        }

        public void pop() {
            if(stack.pop().equals(xStack.peek())){
                xStack.pop();
            }
        }

        public int top() {
           return stack.peek();
        }

        public int getMin() {
            return xStack.peek();
        }
    }
}
