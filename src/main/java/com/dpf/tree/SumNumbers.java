package com.dpf.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求根节点到叶节点数字之和
 * @Author Pikachues
 * @Date 2021/12/16
 */
public class SumNumbers {
    public static void main(String[] args) {

    }

    static class Solution {
        int sum = 0;

        public int sumNumbers(TreeNode root) {

            if (root == null) {
                return 0;
            }

            if (root.left != null) {
                preOrderTraversal(root.left, root.val + "");
            }

            if (root.right != null) {
                preOrderTraversal(root.right, root.val + "");
            }
            if (root.left == null && root.right == null) {
                sum += root.val;
            }
            return sum;
        }

        public void preOrderTraversal(TreeNode root, String num) {

            num += root.val;
            if (root.left == null && root.right == null) {
                sum += Integer.parseInt(num);
                return;
            }
            if (root.left != null) {
                preOrderTraversal(root.left, num);
            }
            if (root.right != null) {
                preOrderTraversal(root.right, num);
            }

        }
    }


    class Solution2{
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }
        public int dfs(TreeNode root,int preNum){
            if(root==null){
                return 0;
            }
            int sum = preNum*10+root.val;
            if(root.left==null&&root.right==null){
                return sum;
            }else{
                return dfs(root.left,sum)+ dfs(root.right,sum);
            }
        }

    }


    class Solution3{
        public int sumNumbers(TreeNode root) {
            if(root==null){
                return 0;
            }
            int sum = 0;
            Queue<TreeNode> queueNode = new LinkedList<>();
            Queue<Integer> queueNum = new LinkedList<>();

            queueNode.add(root);
            queueNum.add(root.val);

            while (!queueNode.isEmpty()){
                TreeNode node = queueNode.poll();
                Integer num = queueNum.poll();
                if(node.left==null&&node.right==null){
                    sum+=num;
                }else{
                    if(node.left!=null){
                        queueNode.add(node.left);
                        queueNum.add(num*10+node.left.val);
                    }
                    if(node.right!=null){
                        queueNode.add(node.right);
                        queueNum.add(num*10+ node.right.val);
                    }
                }
            }
            return sum;
        }


    }
}
