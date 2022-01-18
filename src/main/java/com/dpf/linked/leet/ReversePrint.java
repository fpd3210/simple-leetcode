package com.dpf.linked.leet;

import java.util.*;

/**
 * 链表逆序输出
 */
public class ReversePrint {
    public class Solution {
        public int[] reversePrint(ListNode head) {
            Deque<Integer> stack = new LinkedList<>();

            ListNode temp = head;
            while (temp != null) {
                stack.push(temp.val);
                temp = temp.next;
            }
            return Arrays.stream(stack.toArray()).mapToInt(num -> (Integer) num).toArray();
        }

        public int[] reversePrint2(ListNode head) {
            Deque<Integer> stack = new LinkedList<>();

            ListNode temp = head;
            while (temp != null) {
                stack.push(temp.val);
                temp = temp.next;
            }

            int[] res = new int[stack.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = stack.pop();
            }
            return res;
        }


        List<Integer> list = new ArrayList<>();

        /**
         * 递归实现
         * @param head
         * @return
         */
        public int[] reversePrint3(ListNode head) {
            recur(head);
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        public void recur(ListNode head) {
            if (head == null) return;
            recur(head.next);
            list.add(head.val);
        }
    }


}
