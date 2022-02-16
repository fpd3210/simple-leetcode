package com.dpf.bitwise.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Pikachues
 * Created 2022/2/9
 */
public class SingleNumber2 {
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                if(map.containsKey(num)){
                    if(map.get(num)+1==3){
                        map.remove(num);
                    }else {
                        map.put(num,map.get(num)+1);
                    }
                }else{
                    map.put(num,1);
                }
            }
            Set<Integer> set = map.keySet();
            int res = 0;
            for (int num:set){
                res = num;
            }
            return res;
        }
    }
}