package com.dpf.tree.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 翻转二叉树
 * @Author Pikachues
 * @Date 2021/12/15
 */
public class InvertTree {

   static class Solution {

       /**
        * 从上到下依次交换左右子节点
        * @param root
        * @return
        */
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return null;
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }

        public TreeNode invertTree2(TreeNode root){

            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.removeFirst();
                if(node!=null){
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;

                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            return root;
        }


    }
}
