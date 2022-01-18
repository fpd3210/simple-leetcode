package com.dpf.linked.leet;

/**
 * @Author Pikachues
 * @Date 2021/11/30
 */
public class DeleteDuplicates {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            ListNode tail = head;
            while(tail.next!=null){
                if(tail.next.val==tail.val){
                    tail.next = tail.next.next;
                }else{
                    tail = tail.next;
                }
            }
            return head;
        }
    }
}
