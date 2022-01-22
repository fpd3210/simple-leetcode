package com.dpf.dfs.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2
 * @author Pikachues
 * Created 2022/1/22
 */
public class PermuteUnique {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3};
        System.out.println(solution.permuteUnique(arr));
    }

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            if(nums==null||nums.length==0){
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();

            dfs(nums,new ArrayList<>(),res,new boolean[nums.length]);

            return res;
        }

        public void dfs(int[] nums,List<Integer> temp,List<List<Integer>> res,boolean[] used){
            if(temp.size()==nums.length){
                res.add(new ArrayList<>(temp));
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                if(i>0&&nums[i]==nums[i-1]&&used[i-1]){
                    // 剪枝，上一个相同数字已经使用过
                    continue;
                }

                if(!used[i]){
                    used[i] = true;
                    temp.add(nums[i]);
                    dfs(nums,temp,res,used);
                    used[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
