package com.wangzemin.leetcode;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        Stack<String> simplifyStack = new Stack<>();
        for (String folder : folders) {
            folder = folder.trim();
            if ("".equals(folder) || ".".equals(folder)) {
                continue;
            }
            if ("..".equals(folder)) {
                if (!simplifyStack.empty()) {
                    simplifyStack.pop();
                }
                continue;
            }
            simplifyStack.push(folder);
        }
        StringBuilder simplifyPath = new StringBuilder();
        while (!simplifyStack.isEmpty()) {
            simplifyPath.insert(0, simplifyStack.pop());
            simplifyPath.insert(0, "/");
        }
        if ("".equals(simplifyPath.toString())){
            simplifyPath.insert(0, "/");
        }
        return simplifyPath.toString();
    }
}
