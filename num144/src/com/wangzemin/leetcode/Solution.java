package com.wangzemin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        PriorityQueue q;
        List<Integer> preOrderRes = new ArrayList<>();
        Stack<TreeNode> rightNodes = new Stack<>();
        if (root == null) {
            return preOrderRes;
        }
        while (root != null) {
            while (root != null) {
                preOrderRes.add(root.val);
                if (root.right != null) {
                    rightNodes.push(root.right);
                }
                root = root.left;
            }
            if (!rightNodes.isEmpty()) {
                root = rightNodes.pop();
            }
        }
        return preOrderRes;
    }
}