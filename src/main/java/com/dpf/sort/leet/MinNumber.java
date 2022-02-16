package com.dpf.sort.leet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小数
 * @author Pikachues
 * Created 2022/2/11
 */
public class MinNumber {
    class Solution {
        public String minNumber(int[] nums) {
            String[] res = new String[nums.length];
            for(int i=0;i<nums.length;i++){
                res[i] = Integer.toString(nums[i]);
            }

            Arrays.sort(res, (o1, o2) -> {
                String s1 = o1.concat(o2);
                String s2 = o2.concat(o2);
                return s1.compareTo(s2);
            });

            StringBuilder sb = new StringBuilder();
            for (String re : res) {
                sb.append(re);
            }

            return sb.toString();
        }
    }
}
