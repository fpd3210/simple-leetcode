package com.dpf.linked.leet;

/**
 * 相交链表
 * @Author Pikachues
 * @Date 2021/12/6
 */
public class GetIntersectionNode {
    public class Solution {
        /**
         * 暴力匹配
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB;
            while(curA!=null){
                curB = headB;
                while(curB!=null){
                    if(curA.val==curB.val&&curB.equals(curA)){
                        return curA;
                    }
                    curB = curB.next;
                }
                curA = curA.next;
            }
            return null;
        }

        /**
         * 求长度，从同一位置开始对比
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            ListNode curA = headA,curB = headB;
            int lenA =0,lenB = 0;

            while (curA!=null||curB!=null){
                if(curA!=null){
                    lenA++;
                    curA = curA.next;
                }
                if(curB!=null){
                    lenB++;
                    curB = curB.next;
                }
            }

            int index = 0;
            curA = headA;
            curB = headB;
            if(lenA>lenB){
                while (curA!=null){
                    if(++index==(lenA-lenB)){
                        curA = curA.next;
                        break;
                    }
                    curA = curA.next;
                }
            } else if(lenA<lenB){
                while (curB!=null){
                    if(++index==(lenB-lenA)){
                        curB = curB.next;
                        break;
                    }
                    curB = curB.next;
                }
            }

            while (curA!=null&&curB!=null){
                if(curA.val==curB.val&&curA.equals(curB)){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }

        /**
         * 我走过自己走过的路，你走过你走过的路，我再走你的路，你再走我的路，如果有缘的话我们迟早会相遇
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            if(headA==null||headB==null){
                return null;
            }
            ListNode curA = headA,curB = headB;
            while (curA!=curB){
                curA = curA==null?headB:curA.next;
                curB = curB==null?headA:curB.next;
            }
            return curA;
        }
    }



}
