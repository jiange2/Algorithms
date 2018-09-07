package com.jiange2.argorithms.leetcode;

public class P27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int start = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] != val) ++right;
            int len = right - left ;
            System.arraycopy(nums, left, nums, start, len);
            start += len;
            left = right + 1;
            ++right;
        }
        return start;
    }


}
