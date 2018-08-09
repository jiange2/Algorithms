package com.jiange2.argorithms.leetcode;


public class P7ReverseInteger {



    public int reverse(int x) {

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        long t = 0;
        while (x > 0) {
            t = t * 10 + x % 10;
            x /= 10;
        }

        int r = t > Integer.MAX_VALUE ? 0 : (int) t;

        return isNegative ? -r : r;
    }

}
