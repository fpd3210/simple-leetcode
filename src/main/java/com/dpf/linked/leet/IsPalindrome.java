package com.dpf.linked.leet;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Pikachues
 * @Date 2021/11/30
 */
public class IsPalindrome {
    /**
     * 栈实现
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode tail = head;
        while (tail != null) {
            stack.push(tail.val);
            tail = tail.next;
        }
        tail = head;
        while (tail != null) {
            if (tail.val != stack.pop()) {
                return false;
            }
            tail = tail.next;
        }

        return true;
    }



    /**
     * 栈优化：折半入栈
     * 快指针从head开始，
     * 总节点数量为奇数个时，fast走到最后，slow刚好到中间位置
     * 总结点数量为偶数个时，fast走到最后，slow刚好走到对称轴的右边
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }

        slow = head;

        while (!stack.isEmpty()) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }


    /**
     * 栈优化：折半入栈
     * 快指针从head.next开始,
     * 总节点数量为奇数个时，fast走到最后，slow刚好到中间位置
     * 总结点数量为偶数个时，fast走到最后，slow刚好走到对称轴的左边
     *
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }

        slow = head;

        while (!stack.isEmpty()) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    /**
     * 到中间后逆序
     * @param head
     * @return
     */
    public static boolean isPalindrome4(ListNode head) {

        if(head==null||head.next==null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 找到中间位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 逆序
        fast = slow.next; //fast当前节点
        slow.next = null; // slow 当前节点的前一节点
        ListNode next = null; // 当前节点的下一节点
        while (fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }

        // 比对
        next = slow; // 保存最后一个节点
        fast = head;
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                res = false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        // 还原
        slow = next;
        fast = slow.next;
        next.next = null;
        while (fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        return res;
    }


    /**
     * 递归实现
     * @param head
     * @return
     */
    public boolean isPalindrome5(ListNode head){
        tempNode = head;
        return recursivelyCheck(head);
    }

    private ListNode tempNode = null;

    private boolean recursivelyCheck(ListNode currentNode){
        if(currentNode!=null){
            if(!recursivelyCheck(currentNode.next)){
                return false;
            }
            if (currentNode.val != tempNode.val){
                return false;
            }
            tempNode = tempNode.next;
        }
        return true;
    }


    /**
     * 双指针实现
     * @param head
     * @return
     */
    public boolean isPalindrome6(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size()-1;
        while (left<right){
            if(!list.get(left++).equals(list.get(right--))){
                return false;
            }
        }
        return true;
    }
}
