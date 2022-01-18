package com.dpf.linked.leet;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author Pikachues
 * @Date 2021/11/30
 */
public class DeleteDuplicates2 {
    class Solution {
        /**
         * oneself 哈希表
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            Map<Integer,Integer> map = new TreeMap<>();

            ListNode tail = head;
            while(tail!=null){

                if(map.containsKey(tail.val)){
                    map.put(tail.val,map.get(tail.val)+1);
                }else{
                    map.put(tail.val,1);
                }

                tail = tail.next;
            }

            ListNode res = new ListNode();
            tail = res;

            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue()==1){
                    tail.next = new ListNode(entry.getKey());
                    tail = tail.next;
                }
            }

            return res.next;
        }

        /**
         * oneself 一次循环解决
         * @param head
         * @return
         */
        public ListNode deleteDuplicates2(ListNode head) {
            if(head==null||head.next==null){
                return head;
            }
            //
            ListNode dump = new ListNode(0,head);
            // 当前遍历节点的前一个节点
            ListNode tailPre = dump;
            // 当前遍历节点
            ListNode tail =dump.next;

            while(tail!=null){
                // 当前节点的下一个存在，并且当前节点的下一个节点的值相当
                if(tail.next!=null&&tail.next.val == tail.val){
                    // 新建一个标识走过所有当前节点的值
                    ListNode flag = tail.next.next;
                    while(flag!=null){
                        if(flag.val==tail.val){
                            flag = flag.next;
                        }else{
                            break;
                        }
                    }
                    // 当前节点的前一个的后一个等于标识点
                    tailPre.next = flag;
                    tail = tailPre.next;
                }else{
                    tailPre = tail;
                    tail = tail.next;
                }
            }


            return dump.next;
        }
    }



}
