package com.dpf.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一个路径
 * @author Pikachues
 * Created 2022/2/11
 */
public class PathSum {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(res,new ArrayList<>(),root,target,0);
            return res;
        }

        public void dfs(List<List<Integer>> res, List<Integer> temp, TreeNode root, int target, int sum){
            if(root==null){
                return;
            }

            sum+=root.val;
            temp.add(root.val);
            if(root.left==null&&root.right==null&&target==sum){
                res.add(new ArrayList<>(temp));
            }

            dfs(res,temp,root.left,target,sum);
            dfs(res,temp,root.right,target,sum);
            temp.remove(temp.size()-1);
        }
    }
}
