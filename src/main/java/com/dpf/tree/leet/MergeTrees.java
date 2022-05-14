package com.dpf.tree.leet;

/**
 * 合并二叉树
 * @Author Pikachues
 * @Date 2021/12/18
 */
public class MergeTrees {
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
            if(root1==null&&root2==null){
                return null;
            }
            TreeNode node;
            TreeNode left;
            TreeNode right;
            if(root1==null&&root2!=null){
                node = new TreeNode(root2.val);
                left = mergeTrees(null,root2.left);
                right = mergeTrees(null,root2.right);
            }else if(root2==null&&root1!=null){
                node = new TreeNode(root1.val);
                left = mergeTrees(root1.left,null);
                right = mergeTrees(root1.right,null);
            }else{
                node = new TreeNode(root1.val+root2.val);
                left = mergeTrees(root1.left,root2.left);
                right = mergeTrees(root1.right,root2.right);
            }

            node.left = left;
            node.right = right;

            return node;
        }
    }
}
