package com.dpf.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 多数元素
 * @Author Pikachues
 * @Date 2021/12/6
 */
public class MajorityElement {

    class Solution {
        /**
         * 排序
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }

        /**
         * 哈希
         * @param nums
         * @return
         */
        public int majorityElement2_1(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }else {
                    map.put(num,1);
                }
            }
            for (Map.Entry<Integer,Integer> m:map.entrySet()){
                if(m.getValue()>nums.length>>1){
                    return m.getKey();
                }
            }
            return -1;
        }

        /**
         * 哈希 merge 写法
         * @param nums
         * @return
         */
        public int majorityElement2_2(int[] nums) {
            Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            for (Map.Entry<Integer,Long> entry : collect.entrySet()){
                if(entry.getValue()>nums.length>>1){
                    return entry.getKey();
                }
            }
            return -1;
        }

        /**
         * 哈希 merge 写法
         * @param nums
         * @return
         */
        public int majorityElement2_3(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();

            for (int num : nums) {
                map.merge(num,1, (oldValue,value)->oldValue+value);
            }

            for (Map.Entry<Integer,Integer> entry : map.entrySet()){
                if(entry.getValue()>nums.length>>1){
                    return entry.getKey();
                }
            }

            return -1;
        }

        /**
         * 摩尔投票法
         * @param nums
         * @return
         */
        public int majorityElement4(int[] nums) {
            int count = 0;
            int candidate = 0;
            for (int num : nums) {
                if(count==0){
                    candidate = num;
                    count++;
                }else{
                   count = num==candidate?count+1:count-1;
                }
            }

            return candidate;
        }
    }
}
