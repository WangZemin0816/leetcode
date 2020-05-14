package com.wangzemin.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class NodePos{
    int deep;
    int index;
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> roots = Collections.singletonList(root);
        int maxWidth = 1;
        return 0;
    }
}