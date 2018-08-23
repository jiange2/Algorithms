package com.jiange2.argorithms.leetcode;

public class P796RotateString {

    public boolean rotateString(String A, String B) {

        if (A == null) {
            return B == null;
        }

        if (A.equals(B)) {
            return true;
        }
        for (int i = 1; i < A.length(); i++) {
            if ((A.substring(i) + A.substring(0, i)).equals(B)) {
                return true;
            }
        }
        return false;
    }
}
