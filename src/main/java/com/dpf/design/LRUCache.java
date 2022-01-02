package com.dpf.design;

import java.util.*;

/**
 * @Author Pikachues
 * @Date 2021/12/11
 */
public class LRUCache {

    Integer size;
    Integer capacity;
    Map<Integer,DLinkedList> cache = new HashMap<>();
    DLinkedList head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }



    public void put(int key, int value) {

        DLinkedList node = cache.get(key);
        // 如果缓存不存在
        if(node==null){
            DLinkedList newCache = new DLinkedList(key, value);
            cache.put(key,newCache);
            addToHeader(newCache);
            size++;

            // 容量大于最大容量，去除最久未使用的
            if (size>capacity){
                DLinkedList removeTail = removeTail();
                cache.remove(removeTail.key);
                size--;
            }

        }else{
            // 缓存存在，更新缓存，将缓存存入链头
            node.value = value;
            moveToHead(node);
        }
    }

    class DLinkedList{
        int key;
        int value;
        DLinkedList pre;
        DLinkedList next;

        public DLinkedList() {
        }

        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHeader(node);
    }

    private void addToHeader(DLinkedList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DLinkedList removeTail(){

        DLinkedList removeTail = tail.pre;
        removeNode(removeTail);
        return removeTail;
    }


}
