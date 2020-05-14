package com.wangzemin.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {

    static class A{
        @Override
        public int hashCode() {
            return (int)System.currentTimeMillis();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        A a = new A();
        System.out.println(a.hashCode());
        Thread.sleep(1000);
        System.out.println(a.hashCode());
        Thread.sleep(1000);
        System.out.println(a.hashCode());
        Thread.sleep(1000);
        System.out.println(a.hashCode());
        Thread.sleep(1000);


        int n = 3;
        int[][] r = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");
        Iterator<Map.Entry<String,String>> iterable = map.entrySet().iterator();
        map.put("3","2");
//        map.remove("1");
        iterable.next();
        iterable.remove();

        Solution solution = new Solution();
        solution.maxNumberOfFamilies(n, r);
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b00001111;
        int right = 0b11110000;
        int mid = 0b11000011;
        Map<Integer, Integer> occupied = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            if (reservedSeat[1] < 2 || reservedSeat[1] > 9) {
                continue;
            }
            int curValue = occupied.getOrDefault(reservedSeat[0], 0);
            curValue = curValue | 1 << (9 - reservedSeat[1]);
            occupied.put(reservedSeat[0], curValue);
        }
        int maxNumber = 2 * (n - occupied.size());
        for (int row : occupied.keySet()) {
            int curValue = occupied.get(row);
            if ((curValue | left) == left) {
                curValue = curValue | left;
                maxNumber++;
            }
            if ((curValue | right) == right) {
                curValue = curValue | right;
                maxNumber++;
            }
            if ((curValue | mid) == mid) {
                maxNumber++;
            }
        }
        return maxNumber;
    }
}