package com.dpf.tree.leet;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 * @Author Pikachues
 * @Date 2021/12/8
 */
public class InorderTraversal {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root!=null){
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                while (!stack.isEmpty()||temp!=null){
                    if(temp!=null){
                        stack.push(temp);
                        temp = temp.left;
                    }else{
                        temp = stack.pop();
                        res.add(temp.val);
                        temp = temp.right;
                    }
                }

            }
            return res;
        }
    }
}
