package com.wangzemin.leetcode;

import java.util.HashMap;

public class Solution {

    class LineEquation {
        long A;
        long B;
        long C;
        int minX;
        int minY;

        @Override
        public int hashCode() {
            return (int) (A * 31 + B * 31 * 31 + C * 31 * 31 * 31);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LineEquation)) {
                return false;
            }
            LineEquation equation = (LineEquation) obj;
            return (A * equation.C * equation.B == B * equation.A * equation.C)
                    && (A * equation.C * equation.B == C * equation.B * equation.B);
        }
    }
    public int[] bestLine(int[][] points){
        if (points==null){
            return null;
        }
        if (points.length==1){
            return points[0];
        }
        int maxCount = 0;
        HashMap<LineEquation,Integer> countInLine = new HashMap<>();
        for (int i=0;i<points.length-1;i++){
            for (int j=i+1;j<points.length;j++){
                int x0 = points[i][0];
                int y0 = points[i][1];
                int x1 = points[j][0];
                int y1 = points[j][1];
                LineEquation lineEquation = new LineEquation();
                lineEquation.A = y1 - y0;
                lineEquation.B = x1-x0;
                lineEquation.C = y0 * (x1 - x0) - x0 * (y1 - y0);
                if (countInLine.containsKey(lineEquation)){
                    
                }
            }
        }
        return new int[10];
    }
}
