package com.dpf.other;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口
 * @author Pikachues
 * Created 2022/1/15
 */
public class MovingAverages {
    class MovingAverage {
        int size;
        int[] arr;
        int index = 0;
        int len = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            arr = new int[size];
        }

        public double next(int val) {
            arr[index] = val;
            len++;
            index = (index + 1) % size;
            double sum = 0;
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + "\t");
                sum += arr[i];
            }

            return len >= size ? sum / size : sum / len;
        }
    }

    static class MovingAverage2 {
        int size;
        Deque<Integer> deque;
        double sum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage2(int size) {
            this.size = size;
            deque = new ArrayDeque<>();
        }

        public double next(int val) {
            deque.addLast(val);
            if(deque.size()>size){
                sum -= deque.removeFirst();
            }
            sum+=val;
            return sum/deque.size();
        }
    }

    public static void main(String[] args) {
        MovingAverage2 movingAverage2 = new MovingAverage2(3);
        System.out.println(movingAverage2.next(1));
        System.out.println(movingAverage2.next(10));
        System.out.println(movingAverage2.next(3));
        System.out.println(movingAverage2.next(5));


    }
}
