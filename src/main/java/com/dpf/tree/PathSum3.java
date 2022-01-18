package com.dpf.tree;

/**
 * 路径总和III
 * @Author Pikachues
 * @Date 2021/12/19
 */
public class PathSum3 {
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if(root==null){
                return 0;
            }
            dfs(root,targetSum);
            return res;
        }

        int res = 0;

        public void dfs(TreeNode root,int targetSum){
            if(root==null){
                return;
            }
            dfs(root,targetSum,0);
            dfs(root.left,targetSum);
            dfs(root.right,targetSum);
        }

        public void dfs(TreeNode root,int targetSum,int sum){
            if(root==null){
                return;
            }
            sum+=root.val;
            if(sum==targetSum){
                res++;
            }
            dfs(root.left,targetSum,sum);
            dfs(root.right,targetSum,sum);
        }

    }
}
