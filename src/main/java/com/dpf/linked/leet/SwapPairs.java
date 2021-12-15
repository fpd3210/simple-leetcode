package com.dpf.linked.leet;

/**
 * 两两交换链表中的节点
 * @Author Pikachues
 * @Date 2021/12/3
 */
public class SwapPairs {
   static class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head==null||(head!=null&&head.next==null)){
                return head;
            }
            ListNode pre = new ListNode(-1,head);
            ListNode one,two,next;
            next = pre.next.next!=null?pre.next.next.next:null;
            one = pre.next;
            two = pre.next.next;
            pre.next = two;
            two.next = one;
            head = two;
            one.next = next;

            pre = one;
            while (pre.next!=null&&pre.next.next!=null){
                next = pre.next.next.next;
                one = pre.next;
                two = pre.next.next;
                pre.next = two;
                two.next = one;
                one.next = next;
                pre = one;
            }


            return head;
        }

       public ListNode swapPairs2(ListNode head) {

           if(head==null||(head!=null&&head.next==null)){
               return head;
           }

          ListNode pre = new ListNode(-1,head);
          ListNode cur = head;
          ListNode next;
          pre.next = cur.next;
          next = cur.next.next!=null?cur.next.next:null;
          cur.next.next = cur;
          cur.next = next;
          head = pre.next;
          pre = cur;
          cur = next;

          while (cur!=null&&cur.next!=null){
              pre.next = cur.next;
              next = cur.next.next!=null?cur.next.next:null;
              cur.next.next = cur;
              cur.next = next;
              pre = cur;
              cur = next;
          }

           return head;
       }

       public ListNode swapPairs3(ListNode head) {

            ListNode dumpHead = new ListNode(-1,head);
            ListNode temp = dumpHead,node1,node2;
            while (temp.next!=null&&temp.next.next!=null){
                node1 = temp.next;
                node2 = temp.next.next;
                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                temp = node1;
            }

           return dumpHead.next;
       }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode1.next.next = listNode3;
        listNode1.next.next.next = listNode4;
        listNode1.print();
        ListNode listNode = solution.swapPairs3(listNode1);
        listNode.print();

    }
}
