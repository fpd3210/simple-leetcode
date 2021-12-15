package com.dpf.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Pikachues
 * @Date 2021/12/13
 */
public class BuildTree {
    static class Solution {
        private Map<Integer,Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                  map.put(inorder[i],i);
            }
            return builderTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        }

        public TreeNode builderTree(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
            if(preorderLeft>preorderRight){
                return null;
            }
            int inorderRoot = map.get(preorder[preorderLeft]);
            int leftSize = inorderRoot-inorderLeft;
            TreeNode root = new TreeNode(preorder[preorderLeft]);
            root.left = builderTree(preorder,inorder,preorderLeft+1,preorderLeft+leftSize,inorderLeft,inorderRoot-1);
            root.right = builderTree(preorder,inorder,preorderLeft+leftSize+1,preorderRight,inorderRoot+1,inorderRight);
            return root;
        }
    }
}
