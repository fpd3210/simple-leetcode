package com.dpf.linked.leet;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseBetween {
    class Solution {

        /**
         * oneself
         * 思路：用一个新链表存储结果
         *      1.在便利时left之前，right之后直接将节点放到新链表
         *      2.在left与right区间直接入栈，在right时，节点入栈之后，直接将节点依次出栈存入新链表
         * @param head
         * @param left
         * @param right
         * @return
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode res = new ListNode();
            ListNode resTail = res;
            ListNode tail = head;
            Deque<ListNode> stack = new LinkedList<>();
            int index = 1;

            while(tail!=null){

                if(index<left||index>right){
                    resTail.next = new ListNode(tail.val);
                    resTail = resTail.next;
                    tail = tail.next;
                    index++;
                    continue;
                }

                if(index>=left&&index<=right){
                    stack.push(new ListNode(tail.val));
                }

                if(index==right){
                    while(!stack.isEmpty()){
                        resTail.next = stack.pop();
                        resTail = resTail.next;
                    }
                }

                tail = tail.next;
                index++;

            }
            return res.next;
        }



        public ListNode reverseBetween2(ListNode head, int left, int right) {
            ListNode dumpNode = new ListNode(-1);
            dumpNode.next = head;
            ListNode pre = dumpNode;

            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            ListNode cur = pre;
            ListNode next;
            for (int i = left; i <= right; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }

/*            for (int i = 0; i < right - left; i++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
*/

            return dumpNode.next;
        }
    }
}
