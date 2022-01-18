package com.dpf.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * @Author Pikachues
 * @Date 2021/12/13
 */
public class RightSideView {
    /**
     * 层序遍历思想
     */
   static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            int height = height(root);
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i <= height; i++) {
                res.add(level(root,i));
            }
            return res;
        }

        public int level(TreeNode root,int level){
            if(level<1||root==null){
                return -101;
            }
            int res = -101;
            if(level==1){
                res = root.val;
            }

            int rightRes = level(root.right,level-1);
            int leftRes = level(root.left,level-1);
            return res!=-101?res:rightRes!=-101?rightRes:leftRes;
        }


        public int height(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left,right)+1;
        }
    }

    /**
     * 广搜
     */
    static class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }

            int size = 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()){
                size = queue.size();
                while (size>0){

                    TreeNode node = queue.removeFirst();
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }

                    if(size==1){
                        res.add(node.val);
                    }

                    size--;
                }
            }
            return res;
        }


    }
}
