package com.wangzemin.leetcode.n001;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int firstIdx = 0; firstIdx < nums.length - 1; firstIdx++) {
            for (int secondIdx = firstIdx + 1; secondIdx < nums.length; secondIdx++) {
                if (nums[firstIdx] + nums[secondIdx] == target) {
                    return new int[]{nums[firstIdx], nums[secondIdx]};
                }
            }
        }
        return null;
    }
}