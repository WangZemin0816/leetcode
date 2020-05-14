package com.wangzemin.leetcode.n002;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181};
        int[] weight = {5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594};
        int a = solution.bestSeqAtIndex(height, weight);
        int b = 0;
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height.length == 0 || height.length != weight.length) {
            return 0;
        }
        if (height.length == 1) {
            return 1;
        }
        sortHeight(height,weight);
        return findLongestIncSeq(weight);
    }

    public int findLongestIncSeq(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] idxLongest = new int[nums.length];
        int maxLIS = 1;
        idxLongest[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            idxLongest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    idxLongest[i] = max(idxLongest[i], idxLongest[j] + 1);
                }
                maxLIS = max(maxLIS, idxLongest[i]);
            }
        }
        return maxLIS;
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }

    void sortHeight(int[] height, int[] weight) {
        if (height == null || weight == null || height.length == 0 || height.length != weight.length) {
            return ;
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < weight.length; j++) {
                if (height[i]>height[j]
                        ||(height[i]==height[j]&&weight[i]<weight[j])){
                    swapIdsNum(height,j,i);
                    swapIdsNum(weight,j,i);
                }
            }
        }
    }

    void swapIdsNum(int[] nums,int idxA, int idxB){
        int tmp = nums[idxA];
        nums[idxA] = nums[idxB];
        nums[idxB] =tmp;
    }
}
