package com.dpf.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java中的队列一般用法
 */
public class JavaInQueue {
    public static void main(String[] args) {
            base();
    }

    public static void base(){
        Queue<Integer> queue = new LinkedList<>();

        // 入队
        queue.add(1); // 入队，入队失败抛异常
        queue.offer(2);  // 容量受限时适合用此方法，入队成功与否返回boolean
        queue.add(3);
        queue.add(4);

        // 队头查询
        System.out.println(queue.element()); // 为空返回null
        System.out.println(queue.peek()); // 为空抛异常
        // 出队，删除队头
        System.out.println(queue.poll()); // 为空返回null
        System.out.println(queue.remove()); //为空抛异常
    }
}
