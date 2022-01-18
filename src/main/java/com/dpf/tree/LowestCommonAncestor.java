package com.dpf.tree;

/**
 * 二叉树的最近公共祖先
 * @Author Pikachues
 * @Date 2021/12/12
 */
public class LowestCommonAncestor {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // p,q父子关系
            if(isContains(p,q)){
                return p;
            }
            if(isContains(q,p)){
                return q;
            }
            // p,q在不同树下
            return search(root,p,q);
        }
        public boolean isContains(TreeNode father,TreeNode son){
            if(father.equals(son)){
                return true;
            }
            boolean lRes = false;
            boolean rRes = false;
            if(father.left!=null){
                lRes = isContains(father.left,son);
            }
            if(father.right!=null){
                rRes = isContains(father.right,son);
            }
            return rRes||lRes;
        }

        public TreeNode search(TreeNode root,TreeNode p,TreeNode q){
            TreeNode res = null;
            if(searchSon(root,p)&&searchSon(root,q)){
                res = root;
            }
            if(root.left!=null){
                TreeNode leftRes = search(root.left, p, q);
                res = leftRes==null?res:leftRes;
            }
            if(root.right!=null){
                TreeNode rightRes = search(root.right,p,q);
                res = rightRes==null?res:rightRes;
            }
            return res;
        }

        public boolean searchSon(TreeNode father,TreeNode son){
            if(father.equals(son)){
                return true;
            }
            boolean lRes = false;
            boolean rRes = false;
            if(father.left!=null){
                lRes = searchSon(father.left,son);
            }
            if(father.right!=null){
                rRes = searchSon(father.right,son);
            }

            return lRes||rRes;
        }
    }
}
