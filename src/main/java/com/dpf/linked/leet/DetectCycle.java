package com.dpf.linked.leet;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环形链表II
 * @Author Pikachues
 * @Date 2021/11/29
 */
public class DetectCycle {

   public class Solution{
       /**
        * 快慢指针
        * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
        * 时间复杂都O(n)
        * 空见O(1)
        * @param head
        * @return
        */
        public ListNode detectCycle(ListNode head){
            ListNode slow = head,fast = head;
            while (true){
                if(fast==null||fast.next==null){
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
                if(slow==fast){
                    break;
                }
            }
            fast = head;
            while (slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }


       /**
        * 哈希
         * @param head
        * @return
        */
       public ListNode detectCycle2(ListNode head){

            Set<ListNode> set = new HashSet<>();
            ListNode tail = head;
            while (tail!=null){
                if(set.contains(tail)){
                    return tail;
                }else {
                    set.add(tail);
                }
                tail = tail.next;

            }

            return null;
       }
    }
}
