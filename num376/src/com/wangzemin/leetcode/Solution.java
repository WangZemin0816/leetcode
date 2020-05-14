package com.wangzemin.leetcode;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] upper = new int[nums.length];
        int[] lower = new int[nums.length];
        upper[0] = 1;
        lower[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                upper[i] = lower[i - 1] + 1;
                lower[i] = lower[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                lower[i] = upper[i - 1] + 1;
                upper[i] = upper[i - 1];
            } else {
                lower[i] = lower[i - 1];
                upper[i] = upper[i - 1];
            }
        }
        return Math.max(lower[lower.length - 1], upper[upper.length - 1]);
    }
}
