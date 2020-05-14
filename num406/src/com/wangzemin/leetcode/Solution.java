package com.wangzemin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p2[0] != p1[0]) {
                return p2[0] - p1[0];
            }
            return p1[1] - p2[1];
        });
        List<int[]> shorted = new LinkedList<>();
        for (int[] p : people) {
            shorted.add(p[1],p);
        }
        return shorted.toArray(new int[0][0]);
    }
    public static void main(String[] args){
        int[][] a = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution solution = new Solution();
        solution.reconstructQueue(a);
    }
}