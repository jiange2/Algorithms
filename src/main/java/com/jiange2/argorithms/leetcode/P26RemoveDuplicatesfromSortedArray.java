package com.jiange2.argorithms.leetcode;

public class P26RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 0, placeIndex = 0;
        while (index < nums.length){
            while (index + 1 < nums.length && nums[index] == nums[index + 1]){
                ++index;
            }
            nums[placeIndex++] = nums[index++];
        }
        return placeIndex;
    }
}
