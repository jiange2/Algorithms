package com.jiange2.argorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class P16Sum3Closest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);


        int minSum = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];

                int distance = distance(sum, target);
                if (distance <= min) {
                    min = distance;
                    minSum = sum;
                }


                if (sum > target) {
                    --high;
                } else if (sum < target) {
                    ++low;
                } else {
                    return minSum;
                }


            }
        }

        return minSum;
    }

    private static int distance(int x, int y) {
        if (y > x) {
            return y - x;
        } else {
            return x - y;
        }
    }

    private static int abs(int num) {
        return num > 0 ? num : -num;
    }
}
