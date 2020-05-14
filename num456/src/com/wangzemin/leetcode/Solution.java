package com.wangzemin.leetcode;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        boolean positiveFlag = false;
        boolean negativeFlag = false;
        for (int i = 1; i < nums.length; i++) {
           if(nums[i] - nums[i - 1]>0) {
               positiveFlag = true;
           }
           if (nums[i] - nums[i - 1]<0&&positiveFlag){
               negativeFlag = true;
           }
           if (positiveFlag&&negativeFlag){
               return true;
           }
        }
        return false;
    }
}