package com.wangzemin.leetcode;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {

    @Test
    public void testNullPoint() {
        Solution solution = new Solution();
        int pos = solution.search(null, 1);
        assertEquals(pos, -1);
    }

    @Test
    public void testNotExist() {
        Solution solution = new Solution();
        int[] array = new int[]{5, 6, 7, 1, 2, 3};
        int pos = solution.search(array, 0);
        assertEquals(pos, -1);
    }

    @Test
    public void testInOrder() {
        Solution solution = new Solution();
        int[] array = new int[]{1, 2, 3, 5, 6, 7};
        int pos = solution.search(array, 3);
        assertEquals(pos, 3);
    }

    @Test
    public void testRotated() {
        Solution solution = new Solution();
        int[] array = new int[]{5, 6, 7, 1, 2, 3};
        int pos = solution.search(array, 2);
        assertEquals(pos, 4);
    }
}