package com.dpf.tree.leet;

/**
 * 验证二叉搜索树:中序遍历有序
 * @Author Pikachues
 * @Date 2021/12/14
 */
public class IsValidBST {

    static class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root,long leftMin,long rightMax){
            if(root==null){
                return true;
            }
            if(root.val<=leftMin||root.val>=rightMax){
                return false;
            }
            return isValidBST(root.left,leftMin, root.val)&&isValidBST(root.right, root.val, rightMax);
        }
    }

    static class Solution2{
        public boolean isValidBST(TreeNode root) {
            return inorder(root);
        }
        long pre = Long.MIN_VALUE;
        public boolean inorder(TreeNode root){
            if(root==null){
                return true;
            }
            boolean leftFlag = inorder(root.left);
            if(pre>=root.val){
                return false;
            }
            pre = root.val;
            boolean rightFlag = inorder(root.right);
            return leftFlag&&rightFlag;
        }
    }
}
