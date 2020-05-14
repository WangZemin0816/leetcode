package com.wangzemin.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagRes = new ArrayList<>();
        if (root == null) {
            return zigzagRes;
        }
        List<TreeNode> parents = Collections.singletonList(root);
        boolean rightDirectFlag = true;
        while (parents.size() > 0) {
            List<Integer> parentsVal = parents.stream().map(node -> node.val).collect(Collectors.toList());
            zigzagRes.add(parentsVal);
            rightDirectFlag = !rightDirectFlag;
            parents = getChildren(parents, rightDirectFlag);
        }
        return zigzagRes;
    }

    private List<TreeNode> getChildren(List<TreeNode> parents, boolean rightDirectFlag) {
        List<TreeNode> children = new ArrayList<>();
        if (rightDirectFlag) {
            Collections.reverse(parents);
        }
        for (TreeNode parent : parents) {
            if (parent.left != null) {
                children.add(parent.left);
            }
            if (parent.right != null) {
                children.add(parent.right);
            }
        }
        if (!rightDirectFlag) {
            Collections.reverse(children);
        }
        return children;
    }
}