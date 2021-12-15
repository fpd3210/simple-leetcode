package com.dpf.linked.base;

public class SingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next= listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        singleLinkedList.print(listNode1);
        singleLinkedList.reverse(listNode1);
        System.out.println();
        singleLinkedList.print(listNode1);
    }

    public void reverse(ListNode listNode){
        ListNode cur = listNode;
        ListNode reverseRes = null;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = reverseRes;
            reverseRes = cur;
            cur = next;
        }

    }



    public void print(ListNode listNode){
        ListNode temp = listNode;

        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    public static class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
