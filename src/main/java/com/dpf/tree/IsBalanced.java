package com.dpf.tree;

/**
 * 平衡二叉树
 * @Author Pikachues
 * @Date 2021/12/16
 */
public class IsBalanced {

   static class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root)!=-1;
        }

        public int height(TreeNode node){
            if(node==null){
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            if(leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1){
                return -1;
            }else {
                return Math.max(leftHeight,rightHeight)+1;
            }
        }
    }
}
