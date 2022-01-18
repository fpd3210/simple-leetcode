package com.dpf.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前序遍利
 * @Author Pikachues
 * @Date 2021/12/8
 */
public class PreorderTraversal {
    class Solution {

        /**
         * 迭代(栈)
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root==null){
                return res;
            }

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode node = root;
            while(!stack.isEmpty()||node!=null){
                while(node!=null){
                    // 根节点
                    res.add(node.val);
                    // 根节点入栈便于便利右子节点
                    stack.push(node);
                    node = node.left;
                }
                // 便利右子节点
                node = stack.pop();
                node = node.right;
            }
            return res;
        }

        public List<Integer> preorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            }
            return res;
        }


        /**
         * 递归实现
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal3(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversal3(root,res);
            return res;
        }

        public void preorderTraversal3(TreeNode root,List<Integer> res){

            if(root==null){
                return;
            }
            res.add(root.val);
            preorderTraversal3(root.left,res);
            preorderTraversal3(root.right,res);
        }
    }
}
