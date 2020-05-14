package com.wangzemin.leetcode;

import java.math.BigDecimal;

class Solution {
    public static void main(String[] args) {
        
        String command = "URR";
        int[][] obstacles = new int[0][0];
        int x = 3;
        int y=2;
        Solution solution = new Solution();
        solution.robot(command,obstacles,x,y);
    }
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        }
        int[][] commandMatrix = commandToMatrix(command);

        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i][0] > x || obstacles[i][1] > y) {
                continue;
            }
            if (isPointInCommandMatrix(obstacles[i][0],obstacles[i][1],commandMatrix)){
                return false;
            }
        }
        return isPointInCommandMatrix(x,y,commandMatrix);

    }

    boolean isPointInCommandMatrix(int x, int y, int[][] commandMatrix) {
        int commandXLen = commandMatrix.length-1;
        int commandYLen =  commandMatrix[0].length-1;
        int cycle = Math.min(x / commandXLen, y /commandYLen);
        int relativeX = x - commandXLen * cycle;
        int relativeY = y - commandYLen * cycle;
        if (relativeX>commandXLen||relativeY>commandYLen){
            return false;
        }
        return commandMatrix[relativeX][relativeY] == 1;
    }

    public int[][] commandToMatrix(String command) {
        int step_up = 0;
        int step_right = 0;
        for (int i = 0; i < command.length(); i++) {
            if ('U' == command.charAt(i)) {
                step_up++;
            }
            if ('R' == command.charAt(i)) {
                step_right++;
            }
        }
        int[][] stepMatrix = new int[step_right+1][step_up+1];
        int current_x = 0;
        int current_y = 0;
        stepMatrix[current_x][current_y] = 1;
        for (int i = 0; i < command.length(); i++) {
            if ('U' == command.charAt(i)) {
                current_y++;
            }
            if ('R' == command.charAt(i)) {
                current_x++;
            }
            stepMatrix[current_x][current_y] = 1;
        }
        return stepMatrix;
    }
}