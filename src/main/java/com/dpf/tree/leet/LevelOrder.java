package com.dpf.tree.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层序遍历
 * @Author Pikachues
 * @Date 2021/12/12
 */
public class LevelOrder {

    /**
     * 递归解决
     */
   static class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            int high = high(root);
            for (int i = 1; i <= high; i++) {
                List<Integer> temRes = new ArrayList<>();
                levelOrder(i,root,temRes);
                res.add(temRes);
            }
            return res;
        }

       /**
        * 获取每一层数据
        * @param level
        * @param root
        * @param temRes
        */
        public void levelOrder(int level,TreeNode root,List<Integer> temRes){
            if(level<1||root==null){
                return;
            }
            if(level==1){
                temRes.add(root.val);
            }
            levelOrder(level-1,root.left,temRes);
            levelOrder(level-1,root.right,temRes);
        }

       /**
        * 获取高度
        * @param root
        * @return
        */
        public int high(TreeNode root){
            if(root==null){
                return 0;
            }
            int left = high(root.left);
            int right = high(root.right);
            return (Math.max(left, right))+1;
        }
    }

    /**
     * 迭代实现
      */
   static class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size()>0){
                int size = queue.size();
                List<Integer> tem = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode t = queue.remove(0);
                    tem.add(t.val);
                    if(t.left!=null){
                        queue.add(t.left);
                    }
                    if(t.right!=null){
                        queue.add(t.right);
                    }
                }
                res.add(tem);
            }
            return res;
        }
    }
}
