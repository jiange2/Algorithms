package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P31PartitionArray {

    public int partitionArray(int[] nums, int k) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            while (nums[low] < k && low < high) {
                ++low;
            }

            if (!(low < high)){
                if(k > nums[low]){
                    System.out.println(true);
                    ++low;
                }else{
                    System.out.println(false);
                }
                break;
            }

            while (nums[high] >= k && low < high) {
                --high;
            }

            if (!(low < high)){
                break;
            }

            swap(nums, low++, high--);
        }
        return low;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    public void test() {
        int[] arr = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
        System.out.println(partitionArray(arr,9));
    }
}
