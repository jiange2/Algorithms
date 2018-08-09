package com.jiange2.argorithms.leetcode;


public class P9PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int t = 1;
        while (t * 10 <= x && t < 1000000000){
            t *= 10;
        }


        while(t > 0){
            if(x / t % 10 != x % 10){
                return false;
            }
            x = x / 10;
            t /= 100;
        }
        return true;
    }

}
