package com.dpf.linked.leet;

/**
 * 链表两数之和
 */
public class AddTwoNumbers {
   public  class Solution {
       /**
        * oneself writing
        * @param l1
        * @param l2
        * @return
        */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode temp = res;
            int next = 0;
            while(l1!=null&&l2!=null){
                int sum = l1.val+l2.val+next;
                next = 0;
                if(sum>9){
                    next = sum/10;
                    sum = sum % 10;
                }

                temp.next = new ListNode(sum);

                l1 = l1.next;
                l2 = l2.next;
                temp = temp.next;

            }

            while(l1!=null){
                int sum = l1.val+next;
                next = 0;
                if(sum>9){
                    next = sum/10;
                    sum = sum % 10;
                }
                temp.next = new ListNode(sum);
                temp = temp.next;
                l1 =l1.next;
            }

            while(l2!=null){
                int sum = l2.val+next;
                next = 0;
                if(sum>9){
                    next = sum/10;
                    sum = sum % 10;
                }
                temp.next = new ListNode(sum);
                temp = temp.next;
                l2 = l2.next;
            }

            if(next>0){
                temp.next = new ListNode(next);
            }

            return res.next;
        }

       /**
        * leetcode offical
         * @param l1
        * @param l2
        * @return
        */
       public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode res = null,temp = null;
            int carry = 0;
            while (l1 != null || l2 != null){
                int num1 = l1 == null ? 0 : l1.val;
                int num2 = l2 == null ? 0 : l2 .val;
                int sum = num1 + num2 + carry;
                if(res == null){
                    res = temp = new ListNode(sum % 10);
                }else{
                    temp.next = new ListNode(sum % 10);
                    temp = temp.next;
                }

                if(l1!=null){
                    l1 = l1.next;
                }

                if(l2!=null){
                    l2 = l2.next;
                }
                carry = sum/10;

            }
            if(carry>0){
                temp.next = new ListNode(carry);
            }

            return res;
       }
    }
}
