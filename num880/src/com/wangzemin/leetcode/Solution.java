package com.wangzemin.leetcode;

class Solution {

    public static void main(String[] args) {


        String S = "yyuele72uthzyoeut7oyku2yqmghy5luy9qguc28ukav7an6a2bvizhph35t86qicv4gyeo6av7gerovv5lnw47954bsv2xruaej";
        int K = 123365626;
        Solution solution = new Solution();
        String s = solution.decodeAtIndex(S, K);
        int a = 1;
    }

    public String decodeAtIndex(String S, int K) {
        long[] lengthInIdx = new long[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if ('0' <= S.charAt(i) && '9' >= S.charAt(i)) {
                if (i == 0) {
                    lengthInIdx[i] = 0;
                    continue;
                }
                int repNum = S.charAt(i) - '0';
                lengthInIdx[i] = lengthInIdx[i - 1] * repNum;
            }
            if ('a' <= S.charAt(i) && 'z' >= S.charAt(i)) {
                if (i == 0) {
                    lengthInIdx[i] = 1;
                    continue;
                }
                lengthInIdx[i] = lengthInIdx[i - 1] + 1;
            }
        }

        if (K > lengthInIdx[S.length() - 1]) {
            return null;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            if ('0' <= S.charAt(i) && '9' >= S.charAt(i) && i > 0) {
                if (K > lengthInIdx[i - 1]) {
                    K = K % (int) lengthInIdx[i - 1];
                }

                if (K == 0) {
                    K = (int) lengthInIdx[i - 1];
                }
                continue;
            }
            if (lengthInIdx[i] == K) {
                return S.charAt(i) + "";
            }
        }
        return null;

    }

}