package com.dpf.dfs.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和II
 * @author Pikachues
 * Created 2022/1/22
 */
public class CombinationSum2 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if(candidates==null||candidates.length==0){
                return new ArrayList<>();
            }
            // 为剪枝做准备
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            dfs(candidates,0,target,new ArrayList<>(),res);
            return res;
        }

        public void dfs(int[] candidates,int begin,int target,List<Integer> temp,List<List<Integer>> res){
            if(target<0){
                return;
            }
            if(target==0){
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                // 剪枝
                if(target-candidates[i]<0||i>begin&&candidates[i]==candidates[i-1]){
                    continue;
                }
                temp.add(candidates[i]);
                dfs(candidates, i+1, target-candidates[i], temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
