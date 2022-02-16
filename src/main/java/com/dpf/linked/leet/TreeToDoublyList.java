package com.dpf.linked.leet;

/**
 * 二叉搜索树与双向链表
 * @author Pikachues
 * Created 2022/2/10
 */
public class TreeToDoublyList {

    static class Solution {
        Node head;
        Node pre;
        public Node treeToDoublyList(Node root) {

            if(root==null){
                return root;
            }

            postorderTraversal(root);
            head.left = pre;
            pre.right = head;

            return head;
        }

        public void postorderTraversal(Node root){
            if(root==null){
                return;
            }

            postorderTraversal(root.left);

            if(head==null){
                head = root;
            }else{
                pre.right = root;
                root.left = pre;
            }
            pre = root;

            postorderTraversal(root.right);


        }
    }




   static class Node {
        public int val;
        public Node left;  //前一个
        public Node right; //后一个

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
