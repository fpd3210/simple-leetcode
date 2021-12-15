package com.dpf.linked.other;


/**
 * 其他题目
 * @Author Pikachues
 * @Date 2021/12/1
 */
public class Question1 {

    public static ListNode question1_2(ListNode head, int target){

        int size = 0;
        ListNode cur = head;
        while (cur!=null){
            size++;
            cur = cur.next;
        }

        ListNode[] listNodes = new ListNode[size];
        cur = head;
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = cur;
            cur = cur.next;
        }

        partition(listNodes,target);
        for (int i = 0; i < listNodes.length-1; i++) {
            listNodes[i].next = listNodes[i+1];
        }
        listNodes[listNodes.length-1].next = null;

        return listNodes[0];

    }

    private static void partition(ListNode[] listNodes, int target) {

        int left = 0;
        int less = left-1,more=listNodes.length-1;
        while (left<more){
           if(listNodes[left].val<target){
               swap(listNodes,left++,++less);
           }else if(listNodes[left].val>target){
               swap(listNodes,--more,left);
           }else {
               left++;
           }
        }
    }

    private static void swap(ListNode[] listNodes, int left, int right) {
        ListNode temp = listNodes[left];
        listNodes[left] = listNodes[right];
        listNodes[right] = temp;
    }

    /**
     * 将单链表按某值划分成左边小，中间相等，右边大的形式
     */
    public static ListNode question1_1(ListNode head,int target){
        
        ListNode lH = null;
        ListNode lT = null;
        ListNode mH = null;
        ListNode mT = null;
        ListNode rH = null;
        ListNode rT = null;

        ListNode next = head;
        while (head!=null){
            next = head.next;
            head.next = null;
            if(head.val <target){
                if(lH==null){
                    lH = head;
                    lT = head;
                }else {
                    lH.next = head;
                    lT = head;
                }
            }
            if(head.val==target){
                if(mH==null){
                    mH = head;
                    mT = head;
                }else {
                    mH.next = head;
                    mT = head;
                }
            }else {
                if(rH==null){
                    rH = head;
                    rT = head;
                }else{
                    rH.next = head;
                    rT = head;
                }
            }
            head = next;
        }

        if(lH!=null){
            lT.next = mH;
            mT = mT==null?lT:mT;
        }
        if(mT!=null){
            mT.next = rH;
        }

/*        if(lH!=null){
            return lH;
        }else if(mH!=null){
            return mH;
        }else{
            return rH;
        }*/

        return lH!=null?lH:mH!=null?mH:rH;
    }

    public static void printLinkedNode(ListNode head){
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(8);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(6);

        listNode.next = listNode2;
        listNode.next.next = listNode3;
        listNode.next.next.next = listNode4;
        listNode.next.next.next.next = listNode5;

        ListNode listNode1 = question1_1(listNode, 3);
        printLinkedNode(listNode1);

        listNode.next = listNode2;
        listNode.next.next = listNode3;
        listNode.next.next.next = listNode4;
        listNode.next.next.next.next = listNode5;
        ListNode listNode6 = question1_2(listNode, 3);
        printLinkedNode(listNode6);

    }
}
