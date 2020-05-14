package com.wangzemin.leetcode;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        int[] dpMaxLength = new int[nums.length + 1];
        dpMaxLength[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int maxLengthForI = nums[i - 1] + i;
            for (int j = 0; j < i; j++) {
                maxLengthForI = Math.max(maxLengthForI, dpMaxLength[j]);
            }
            dpMaxLength[i] = maxLengthForI;
            if (dpMaxLength[i] <= i && i != nums.length) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int maxLength = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxLength) {
                return false;
            }
            if (maxLength >= nums.length-1) {
                return true;
            }
            maxLength = Math.max(nums[i] + i,maxLength);
        }
        return true;
    }
}