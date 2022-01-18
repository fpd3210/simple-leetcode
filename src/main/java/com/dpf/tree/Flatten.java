package com.dpf.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 * @Author Pikachues
 * @Date 2021/12/17
 */
public class Flatten {

    class Solution {

        public void flatten(TreeNode root) {
            if(root==null){
                return;
            }
            if(root.left==null&&root.right==null){
                return;
            }
            List<TreeNode> res = new ArrayList<>();
            preTraversal(root,res);
            root.right = res.get(1);
            root.left = null;
            TreeNode pre = res.get(1);
            for (int i = 2; i < res.size(); i++) {
                TreeNode curNode = res.get(i);
                pre.right = curNode;
                pre.left = null;
                pre = curNode;
            }
        }

        public void preTraversal(TreeNode root,List<TreeNode> res){
            if(root==null){
                return;
            }
            res.add(root);
            preTraversal(root.left,res);
            preTraversal(root.right,res);
        }

    }

    class Solution2 {
        public void flatten(TreeNode root) {
           TreeNode cur = root;
           while (cur!=null){
               if(cur.left!=null){
                   TreeNode next = cur.left;
                   TreeNode pre = next;
                   while (pre.right!=null){
                       pre = pre.right;
                   }
                   pre.right = cur.right;
                   cur.left = null;
                   cur.right = next;
               }
               cur = cur.right;
           }

        }
    }
}
