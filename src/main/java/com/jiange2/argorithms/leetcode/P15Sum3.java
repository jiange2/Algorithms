package com.jiange2.argorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15Sum3 {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    res.add(list);
                    ++low;
                    while (nums[low] == nums[low - 1] && low < high) {
                        ++low;
                    }
                    --high;
                    while (nums[high] == nums[high + 1] && low < high) {
                        --high;
                    }
                } else if (sum > target) {
                    --high;
                } else {
                    ++low;
                }
            }

        }

        return res;
    }


}
