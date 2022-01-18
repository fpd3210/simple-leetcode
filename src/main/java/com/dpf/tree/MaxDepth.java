package com.dpf.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Pikachues
 * @Date 2021/12/13
 */
public class MaxDepth {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth,rightDepth)+1;
        }

        public int maxDepth2(TreeNode root){

            int depth = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size>0){
                    TreeNode node = queue.removeFirst();
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                    size--;
                }

                depth++;
            }

            return depth;
        }
    }


}
