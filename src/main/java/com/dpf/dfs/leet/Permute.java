package com.dpf.dfs.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全排列
 * @author Pikachues
 * Created 2022/1/17
 */
public class Permute {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(res,nums,new ArrayList<>(),new boolean[nums.length]);
            return res;
        }

        public void dfs(List<List<Integer>> res,int[] nums,List<Integer> temp,boolean[] visited){
            if(temp.size()==nums.length){
                res.add(new ArrayList<>(temp));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(!visited[i]){
                    visited[i] = true;
                    temp.add(nums[i]);
                    dfs(res,nums,temp,visited);
                    visited[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }


    class Solution2 {
        List<List<Integer>> res;
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();

            dfs(0,new int[nums.length],nums,new boolean[nums.length]);
            return res;
        }

        public void dfs(int step,int[] temp,int[] nums,boolean[] book){
            if(step>=nums.length){
                res.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
                return;
            }

            for(int i=0;i<nums.length;i++){
                if(!book[i]){
                    temp[step] = nums[i];
                    book[i] = true;
                    dfs(step+1,temp,nums,book);
                    book[i] = false;
                }
            }
        }
    }
}
