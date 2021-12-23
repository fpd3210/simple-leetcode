package com.dpf.stack.base;

/**
 * 链表模拟栈
 * @author Pikachues
 * Created 2021/12/22
 */
public class MyLinkedStack {
    transient Node first;
    transient Node last;
    transient int size;

    public MyLinkedStack() {
    }

    public void push(int val){
        linkedFirst(val);
    }

    public void linkedFirst(int val){
        Node f = first;
        Node newNode = new Node(val,f);
        first = newNode;
        size++;
    }


    public int pop(){
        return removeFirst();
    }
    public int removeFirst(){
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
