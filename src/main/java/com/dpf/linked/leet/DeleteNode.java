package com.dpf.linked.leet;

/**
 * @Author Pikachues
 * @Date 2021/11/30
 */
public class DeleteNode {
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
