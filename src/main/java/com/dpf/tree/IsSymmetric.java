package com.dpf.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 * @Author Pikachues
 * @Date 2021/12/15
 */
public class IsSymmetric {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }

            return check(root.left,root.right);
        }
        public boolean check(TreeNode left,TreeNode right){
            if(left==null&&right==null){
                return true;
            }
            if(left==null||right==null){
                return false;
            }
            if(left.val!=right.val){
                return false;
            }
            return check(left.left,right.right)&&check(left.right,right.left);
        }
    }

    class Solution2{
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }

            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);
            while (!queue.isEmpty()){
                TreeNode left = queue.removeFirst();
                TreeNode right = queue.removeFirst();
                if(left==null&&right==null){
                    continue;
                }
                if(left==null|right==null){
                    return false;
                }
                if(left.val!=right.val){
                    return false;
                }
                queue.add(left.right);
                queue.add(right.left);

                queue.add(left.left);
                queue.add(right.right);

            }
            return true;
        }
    }

}
