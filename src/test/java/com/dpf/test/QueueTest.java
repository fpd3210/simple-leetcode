package com.dpf.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Pikachues
 * Created 2021/12/21
 */
public class QueueTest {

    public static void main(String[] args) {
        testLinked();
    }

    /**
     *
     * 做队列时
     */
    public static void testLinked(){
        Deque<Integer> deque = new LinkedList<>();  // 链表

        // 添加到 链表尾部
        deque.offer(-1); // -1
        deque.add(0); // -1,0
        deque.addLast(1); // -1,0,1
        deque.addLast(2); // -1,0,1,2
        deque.addLast(3); // -1,0,1,2,3
        // 添加到链表头部
        deque.addFirst(-2); // -2,-1,0,1,2,3

        // 从链表头部查看
        System.out.println(deque.peek());   // peek 窥视，探视，查看
        System.out.println(deque.peekFirst()); // 查看链表头部
        System.out.println(deque.peekLast());  // 查看链表尾部
        System.out.println(deque.peekLast());

        System.out.println(deque.element());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        /*
            除了有Last的都是从链表头部查看
         */
        System.out.println("==============================");

         // 获取  -2,-1,0,1,2,3
        System.out.println(deque.poll());// -2
        System.out.println(deque.pollFirst()); // -1
        System.out.println(deque.pollLast()); // 3
        System.out.println(deque.removeFirst());
        System.out.println(deque.remove());
        System.out.println(deque.removeLast());
        /*
            除了有Last的都是从链表头部删除并返回
         */

    }

    public static void testArray(){
        Deque<Integer> deque = new ArrayDeque<>();


        deque.offer(-1);
        deque.add(0);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(-2);

        System.out.println(deque.pop());

    }
}
