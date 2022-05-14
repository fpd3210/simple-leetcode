package com.dpf.tree.leet;

/**
 * 把二叉搜索树转换为累加树
 * @Author Pikachues
 * @Date 2021/12/18
 */
public class ConvertBST {
    /**
     * 暴力
     */
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            if(root==null){
                return null;
            }

            sum =0;
            sum(root, root.val);
            TreeNode res = new TreeNode(sum);

            if(root.left!=null||root.right!=null){
                preTraversal(res,root,root);
            }

            return res;
        }

        public void preTraversal(TreeNode res,TreeNode cur,TreeNode root){
            if(cur==null){
                return;
            }
            if(cur.left!=null){
                sum = 0;
                sum(root,cur.left.val);
                res.left = new TreeNode(sum);
            }
            if(cur.right!=null){
                sum=0;
                sum(root,cur.right.val);
                res.right = new TreeNode(sum);
            }
            preTraversal(res.left,cur.left,root);
            preTraversal(res.right,cur.right,root);
        }

        int sum;

        public void sum(TreeNode root,int target){
            if(root==null){
                return;
            }
            sum += root.val>=target? root.val : 0;
            sum(root.left,target);
            sum(root.right,target);
        }
    }

    /**
     * 反向中序遍历
     */
    class Solution2 {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            if(root!=null){
                convertBST(root.right);
                sum+= root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }


}
