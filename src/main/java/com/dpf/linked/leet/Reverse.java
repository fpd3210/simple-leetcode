package com.dpf.linked.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 带头链表反转
 */
public class Reverse {
    public class Solution {
        /**
         * 双指针写法
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode next = null;
            ListNode pre = null;

            while (cur!=null){
                next = cur.next; // 暂存当前节点的下一个节点
                cur.next = pre;
                pre = cur;
                cur = next;

            }
            return pre;
        }
    }

    public class Solution2 {
        /**
         * 栈实现
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            Deque<ListNode> stack = new LinkedList<>();

            ListNode temp = head;

            while (temp!=null){
                stack.push(temp);
                temp = temp.next;
            }

            ListNode res = new ListNode(stack.pop().val);
            ListNode tempRes = res;
            while (!stack.isEmpty()){
                tempRes.next = new ListNode(stack.pop().val);
                tempRes = tempRes.next;
            }
            return res;
        }
    }


    /**
     * 几乎所有递归实现都可以改为栈实现
     */
    public class Solution3 {
        /**
         * 递归实现
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            return recur(head,null);
        }

        private ListNode recur(ListNode cur, ListNode pre) {
            if(cur==null) return pre;
            ListNode res = recur(cur.next,cur);
            cur.next = pre;
            return res;
        }
    }



}

