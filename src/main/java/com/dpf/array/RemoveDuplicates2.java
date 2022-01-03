package com.dpf.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pikachues
 * Created 2022/1/3
 */
public class RemoveDuplicates2 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0;
            int pre = nums[0];
            int preCount = 1;
            for(int i=1;i<nums.length;i++){
                if(preCount<2){
                    if(nums[i]!=pre){
                        pre = nums[i];
                        preCount = 1;
                    }else{
                        preCount++;
                    }
                    index++;
                    nums[index] = nums[i];
                }else{
                    if(pre!=nums[i]){
                        pre = nums[i];
                        preCount = 1;
                        index++;
                        nums[index] = nums[i];
                    }
                }
            }
            return index+1;
        }

        public int removeDuplicates2(int[] nums) {
            int index = 0;
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                if(map.containsKey(num)){
                    if(map.get(num)<2){
                        nums[index++] = num;
                    }
                    map.put(num,map.get(num)+1);
                }else {
                    map.put(num,1);
                    nums[index++] = num;
                }
            }
            return index;
        }
    }
}
