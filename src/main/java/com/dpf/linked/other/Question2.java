package com.dpf.linked.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Pikachues
 * @Date 2021/12/3
 */
public class Question2 {

    public static Node question2_1(Node head){
        Map<Node,Node> nodeMap = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            nodeMap.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            nodeMap.get(cur).next = nodeMap.get(cur.next);
            nodeMap.get(cur).rand = nodeMap.get(cur.rand);
            cur = cur.next;
        }
        return nodeMap.get(head);
    }

    public static Node question2_2(Node head){
        Node cur = head;
        while (cur!=null){
            Node copyCur = new Node(cur.value);
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = copyCur.next;
        }

        cur = head;
        Node res = new Node(-1);
        Node resCur = res;
        while (cur!=null){
            resCur.next = cur.next;
            resCur.next.rand = cur.rand!=null?cur.rand.next:null;

            cur = cur.next.next;
            resCur = resCur.next;
        }

        cur = head;
        while (cur!=null){
            cur = cur.next.next;
        }

        return res.next;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node1.next.next = node3;
        node1.rand = node3;
        printRandLinkedList(node1);

        Node question2_1 = question2_1(node1);
        printRandLinkedList(question2_1);

        Node question2_2 = question2_2(node1);
        printRandLinkedList(question2_2);


    }



    static class Node {
        int value;
        Node next;
        Node rand;
        Node(int val) {
            value = val;
        }
    }
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }

        System.out.println();
    }
}
