package com.dpf.linked.leet;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * @Author Pikachues
 * @Date 2021/11/29
 */
public class HashCycle {

    public class Solution {
        /**
         * Hash表解答
         * 最差空间复杂度O(n):每个节点都进一次Hash表
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();

            ListNode tail = head;
            while(tail!=null){

                if(!set.add(tail)){
                    return true;
                }
                tail = tail.next;
            }

            return false;
        }

        /**
         * 快慢指针
         * @param head
         * @return
         */
        public boolean hasCycle2(ListNode head){

            if(head==null||head.next==null){
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (slow!=fast){
                if(fast==null||fast.next==null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
