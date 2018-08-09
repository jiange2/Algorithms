package com.jiange2.argorithms.leetcode;

public class P11MostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = countArea(height,left,right);
        int t;
        while (left < right){
            while(height[left] <= height[right] && left < right){
                t = height[left];
                while (height[left] <= t && left < right){
                    ++left;
                }
                max = Math.max(max, countArea(height,left,right));
            }
            while(height[right] <= height[left] && left < right){
                t = height[right];
                while (height[right] <= t && left < right){
                    --right;
                }
                max = Math.max(max, countArea(height,left,right));
            }
        }
        return max;
    }

    private int countArea(int[] height,int left, int right){
        return Math.min(height[left],height[right]) * (right - left);
    }
}
