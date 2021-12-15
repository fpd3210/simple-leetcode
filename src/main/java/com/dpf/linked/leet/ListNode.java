package com.dpf.linked.leet;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void print(){
        ListNode cur = this;
        while (cur!=null){
            System.out.print(cur.val+"\t");
            cur = cur.next;
        }
        System.out.println();
    }
}
