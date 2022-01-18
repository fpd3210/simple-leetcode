package com.dpf.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @author Pikachues
 * Created 2022/1/18
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> subsets = solution.subsets(arr);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
    static class Solution{
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            dfs(nums,0,temp,res);
            return res;
        }
        public void dfs(int[] nums,int index,List<Integer> temp,List<List<Integer>> res){
            res.add(new ArrayList<>(temp));
            for (int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                dfs(nums,i+1,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }

    /*  index = 0
        i = 0   temp=1
        i = 0   temp=[]
        i = 1   temp=2
        i = 1   temp=[]
        i = 2   temp=3


        index = 1
        i = 1   temp=1,2
        i = 1   temp=1
        i = 2   temp=1,3
        i = 2   temp=1

        index = 2
        i = 2 temp=1,2,3
        i = 2 temp=1,2
        i = 2 temp=2,3
        i = 2 temp=2

        index=3
        i = 3 ×


        res:
        []
        [1]
        [1,2]
        [1,2,3]
        [1,3]
        [2]
        [2,3]
        [3]
    */


    class Solution2 {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            // 取当前值
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            // 不取当前值
            dfs(cur + 1, nums);
        }
    }

}
