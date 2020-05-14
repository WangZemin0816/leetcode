package com.wangzemin.leetcode;

import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> minStack = new Stack<>();
        for (char numCh : num.toCharArray()) {
            int currentNum = numCh-'0';
            while (k>0&&!minStack.isEmpty()&&currentNum<minStack.get(minStack.size()-1)){
                minStack.pop();
                k--;
            }
            if (currentNum!=0||!minStack.isEmpty()){
                minStack.push(currentNum);
            }
        }
        while (k>0&&!minStack.isEmpty()){
            minStack.pop();
            k--;
        }
        StringBuilder removeNum = new StringBuilder();
        while (!minStack.isEmpty()){
            removeNum.insert(0,minStack.pop());
        }
        if (removeNum.length()==0){
            return "0";
        }
        return removeNum.toString();
    }
}