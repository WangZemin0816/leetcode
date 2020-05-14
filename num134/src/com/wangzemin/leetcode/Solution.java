package com.wangzemin.leetcode;

import java.util.ArrayList;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) {
            return -1;
        }
        int sumRemain = 0;
        int currentRemain = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            sumRemain = sumRemain + gas[i] - cost[i];
            currentRemain = currentRemain + gas[i] - cost[i];
            if (currentRemain < 0) {
                startIndex = i + 1;
                currentRemain = 0;
            }
        }
        return sumRemain >= 0 ? startIndex : -1;
    }
}
