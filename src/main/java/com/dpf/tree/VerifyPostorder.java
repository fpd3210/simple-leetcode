package com.dpf.tree;

/**
 * 二叉搜索树的后序遍历序列
 * @author Pikachues
 * Created 2022/2/11
 */
public class VerifyPostorder {
    class Solution{
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        private boolean recur(int[] postorder, int i, int j) {
            if(i>=j){
                return true;
            }

            int left = i;
            // 查找第一个大于根节点的下标（左子树所有节点都小于根节点）
            while (postorder[left]<postorder[j]){
                left++;
            }

            int right = left;
            // 判断[right,j-1]右子树每个节点都大于根节点
            while (postorder[right]>postorder[j]){
                right++;
            }
            return right==j&&recur(postorder, i, left-1)&&recur(postorder,left,j-1);
        }

    }
}
