package com.dpf.linked.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两数相加II
 */
public class AddTwoNumbers2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new LinkedList<>();
            Deque<Integer> stack2 = new LinkedList<>();

            while(l1!=null||l2!=null){
                if(l1!=null){
                    stack1.push(l1.val);
                    l1 = l1.next;
                }
                if(l2!=null){
                    stack2.push(l2.val);
                    l2 = l2.next;
                }
            }

            int carry = 0;
            ListNode res = null;
            while(!stack1.isEmpty()||!stack2.isEmpty()){

                int num1 = stack1.isEmpty()?0:stack1.pop();
                int num2 = stack2.isEmpty()?0:stack2.pop();

                int sum = num1+num2+carry;
                carry = sum/10;

                ListNode cur = new ListNode(sum%10,res);
                res = cur;
            }
            if(carry>0){
                ListNode cur = new ListNode(carry,res);
                res = cur;
            }
            return res;
        }


        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            Deque<Integer> stack1 = new LinkedList<>();
            Deque<Integer> stack2 = new LinkedList<>();

            while(l1!=null||l2!=null){
                if(l1!=null){
                    stack1.push(l1.val);
                    l1 = l1.next;
                }
                if(l2!=null){
                    stack2.push(l2.val);
                    l2 = l2.next;
                }
            }

            int carry = 0;
            ListNode res = null;
            while(!stack1.isEmpty()||!stack2.isEmpty()||carry>0){

                int num1 = stack1.isEmpty()?0:stack1.pop();
                int num2 = stack2.isEmpty()?0:stack2.pop();

                int sum = num1+num2+carry;
                carry = sum/10;

                ListNode cur = new ListNode(sum%10,res);
                res = cur;
            }
            return res;
        }
    }
}
