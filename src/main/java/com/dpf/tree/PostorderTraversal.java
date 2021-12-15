package com.dpf.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历
 *
 * @Author Pikachues
 * @Date 2021/12/8
 */
public class PostorderTraversal {
    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }


    /**
     * 栈实现
     *
     * @param head
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head != null) {
            Deque<TreeNode> s1 = new LinkedList<>();
            Deque<TreeNode> s2 = new LinkedList<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                res.add(s2.pop().val);
            }
        }

        return res;
    }
}
