package com.dpf.queue.base;

/**
 * @author Pikachues
 * Created 2021/12/23
 */
public class MyLinkedQueue {
    transient Node first;
    transient Node last;
    transient int size;

    public MyLinkedQueue() {
    }

    public void add(int val){
        linkLast(val);
    }

    public void linkLast(int val){
        Node l = last;
        Node newNode = new Node(val,null);
        last = newNode;
        if(l==null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }

    public int peek(){
        return first.val;
    }

    public int poll(){
        Node f = first;
        first = first.next;
        size--;
        return f.val;
    }




    private static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
