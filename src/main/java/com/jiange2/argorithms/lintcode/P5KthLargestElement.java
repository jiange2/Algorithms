package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.Arrays;

public class P5KthLargestElement {



    @Test
    public void test() {
       /* int n = 10;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = (int) (Math.random() * n * 10);
        }*/
        int[] a = {9,3,2,4,8};
        System.out.println(Arrays.toString(a));
        System.out.println(kthLargestElement(1, a));
    }

    public int kthLargestElement(int k, int[] nums) {
        if(k<1 || k >nums.length){
            return -1;
        }
        return getKthLargestElementByQuickSort(nums.length-k+1, nums, 0, nums.length-1);
    }

    private int getKthLargestElementByQuickSort(int k, int[] nums, int start, int end) {
        int left = start, right = end;
        //基值
        int t = nums[left];
        while (left < right) {
            while (nums[right] > t && left < right)
                right--;

            if (left < right)
                nums[left++] = nums[right];

            while (nums[left] < t && left < right)
                left++;

            if (left < right)
                nums[right--] = nums[left];
        }
        nums[left] = t;
        //基值为当前区间数组的第pos大数
        int pos = left-start+1;
        if (pos == k) { //基值就是结果
            return nums[left];
        } else if (pos > k) { //因为比基值小的数的数量大于k，所以k在基值左边
            return getKthLargestElementByQuickSort(k, nums, start, left - 1);
        } else {    //反之，基值在右，且问题转变为求k-pos
            return getKthLargestElementByQuickSort(k-pos, nums, left + 1, end);
        }
    }
}
