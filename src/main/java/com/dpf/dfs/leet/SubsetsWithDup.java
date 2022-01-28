package com.dpf.dfs.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 * @author Pikachues
 * Created 2022/1/23
 */
public class SubsetsWithDup {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if(nums==null||nums.length==0){
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> res= new ArrayList<>();
            dfs(0,nums,new ArrayList<>(),res);
            return res;
        }

        public void dfs(int begin,int[] nums,List<Integer> temp,List<List<Integer>> res){
            res.add(new ArrayList<>(temp));
            for (int i = begin; i < nums.length; i++) {
                if(i>begin&&nums[i]==nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                dfs(i+1,nums,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
