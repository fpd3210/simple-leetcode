package com.dpf.linked.leet;


import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的赋值
 * @author Pikachues
 * Created 2022/2/9
 */
public class CopyRandomList {
    class Solution{
        public Node copyRandomList(Node head) {
            if(head==null){
                return null;
            }

            Node res = new Node(head.val);
            Map<Node,Node> map = new HashMap<>();
            map.put(res,head);

            Node temp = head.next;
            Node resTemp = res;

            while (temp!=null){
                resTemp.next = new Node(temp.val);
                map.put(resTemp.next,temp);
                temp = temp.next;
                resTemp = resTemp.next;

            }
            resTemp = res;
            while (resTemp!=null){
                if(map.get(resTemp)!=null&&map.get(resTemp).random!=null){
                    Node random = map.get(resTemp).random;
                    resTemp.random = findRandom(map,random);
                }
                resTemp = resTemp.next;
            }



            return res;
        }

        public Node findRandom(Map<Node,Node> map,Node random){
            for (Map.Entry<Node,Node> entry:map.entrySet()){
                if(entry.getValue().equals(random)){
                    return entry.getKey();
                }
            }
            return null;
        }
    }


    class Solution2 {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }


    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
